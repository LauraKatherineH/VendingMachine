package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        double total = 0;
        String purchaseChoice;
        String mainMenuChoice;
        String slotChoice = " ";
        String itemName;
        int addedAmount = 0;
        boolean isTransactionFinished = false;
        boolean mainLoop = false;
        Scanner userInput = new Scanner(System.in);
        Inventory startInventory = new Inventory();
        Transactions startTransaction = new Transactions();
        Map<String, Items> output = startInventory.inventoryList();

        do {
            do {

                System.out.println("(1) Display Vending Machine Items");
                System.out.println("(2) Purchase");
                System.out.println("(3) Exit");

                mainMenuChoice = userInput.nextLine().trim();
                if (mainMenuChoice.equals("3")){
                    System.exit(0);
                }

                if (mainMenuChoice.equals("1")) {
                    for (Map.Entry<String, Items> printer : output.entrySet()) {
                        System.out.println(printer.getKey() + " " + printer.getValue());
                    }

                }

            } while (mainMenuChoice.equals("1"));

            if (mainMenuChoice.equals("2")) {
                first:
                do {

                    do {
                        System.out.println("Current Money Provided: $" + total);
                        System.out.println(("(1) Feed Money"));
                        System.out.println("(2) Select Product");
                        System.out.println("(3) Finish Transaction");
                        purchaseChoice = userInput.nextLine();

                        if (purchaseChoice.equals("1")) {
                            String moneyFeed = " ";

                            second:
                            do {

                                System.out.println("Please input a whole (positive) dollar amount: ");

                                do{

                                    try { addedAmount = parseInt(userInput.nextLine());} catch(NumberFormatException e){
                                        System.out.println("Please enter a number.");
                                        continue second;
                                    }

                                    if (addedAmount < 0) {
                                        continue second;
                                    }

                                } while (addedAmount <= 0);

                                total = startTransaction.addMoney(addedAmount);
                                System.out.println("Are you finished feeding money to the machine? (Y or N)");
                                moneyFeed = userInput.nextLine().toUpperCase();

                            } while (!moneyFeed.equals("Y"));

                        }

                    } while (!purchaseChoice.equals("3") && !purchaseChoice.equals("2"));



                    if (purchaseChoice.equals("2")) {
                        boolean itemChosen = false;
                        if (total == 0){
                            System.out.println("Please insert money.");
                            continue first;
                        }
                        third:
                        do {

                            System.out.println("Please select slot: ");

                            slotChoice = userInput.nextLine().toUpperCase();


                            if (output.containsKey(slotChoice)) {
                                System.out.println(output.get(slotChoice).toStringSelectedItem());

                                output.get(slotChoice).setProductStock(output.get(slotChoice).getProductStock() - 1);
                                if (output.get(slotChoice).getProductStock() < 0){
                                    output.get(slotChoice).setProductStock(0);
                                    System.out.println("Sold Out");
                                    continue third;
                                }

//                                String selectedItem = output.get(slotChoice).toStringSelectedItem();
//                                String[] selectedItemSplit = selectedItem.split(" ");
//                                String costString = selectedItemSplit[selectedItemSplit.length - 1].substring(1);

                                if (total < output.get(slotChoice).getPrice()) {
                                    System.out.println("Insufficient Funds");

                                    continue first;

                                }





//                                if (selectedItemSplit[1].startsWith("$")){
//                                    itemName = selectedItemSplit[0];
//                                }else if (selectedItemSplit[2].startsWith("$")){
//                                    itemName = selectedItemSplit[0].concat( " " + selectedItemSplit[1]);
//                                }else {
//                                    itemName = selectedItemSplit[0].concat(" " + selectedItemSplit[1]).concat(" " + selectedItemSplit[2]);
//                                }
                                double itemCost = output.get(slotChoice).getPrice();
                                itemName = output.get(slotChoice).getName();

                                total = startTransaction.purchaseItem(itemCost, total, slotChoice, itemName);
                                System.out.println("Current Money Provided: $" + total);

                                if (output.get(slotChoice).getClass().equals(ChipItems.class)) {
                                    System.out.println("Crunch Crunch, Yum!");
                                    System.out.println();

                                }
                                if (output.get(slotChoice).getClass().equals(DrinkItems.class)) {
                                    System.out.println("Glug Glug, Yum!");
                                    System.out.println();
                                }
                                if (output.get(slotChoice).getClass().equals(CandyItems.class)) {
                                    System.out.println("Munch Munch, Yum!");
                                    System.out.println();
                                }
                                if (output.get(slotChoice).getClass().equals(GumItems.class)) {
                                    System.out.println("Chew Chew, Yum!");
                                    System.out.println();
                                }


                                itemChosen = true;


                            } else {
                                System.out.println("Slot doesn't exist, please select another");
                            }
                        } while (!itemChosen);


                    }
                    if (purchaseChoice.equals("3")) {
                        startTransaction.giveChange();
                        System.out.println("Your remaining change is: $" + total);
                        total = 0;
                        isTransactionFinished = true;
                    }

                } while (!isTransactionFinished);

            }

        } while (!mainLoop);
    }
}

