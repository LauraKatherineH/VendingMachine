package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Inventory {


    public  Map<String, Items> inventoryList() {
        Map<String, Items> inventory = new HashMap<>();

        File in = new File("vendingmachine.csv");
        try (Scanner fileReader = new Scanner(in)) {
            do {
                String item = fileReader.nextLine();
                String[] splitItem = item.split("\\|");

                if (splitItem[3].equals("Candy")) {
                    inventory.put(splitItem[0], new CandyItems(splitItem[1], parseDouble(splitItem[2]), 5));
                }
                if (splitItem[3].equals("Drink")) {
                    inventory.put(splitItem[0], new DrinkItems(splitItem[1], parseDouble(splitItem[2]), 5));
                }
                if (splitItem[3].equals("Chip")) {
                    inventory.put(splitItem[0], new ChipItems(splitItem[1], parseDouble(splitItem[2]), 5));
                }
                if (splitItem[3].equals("Gum")) {
                    inventory.put(splitItem[0], new GumItems(splitItem[1], parseDouble(splitItem[2]), 5));
                }

            } while (fileReader.hasNextLine());
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return inventory;


    }
}

