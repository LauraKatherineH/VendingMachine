package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transactions extends Items{

    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a"));
    File logFile = new File("logFile.txt");
    PrintWriter logOutput = new PrintWriter(logFile);
    private double total;


    public Transactions() throws FileNotFoundException {
    }


    public double purchaseItem(double itemCost, double total, String slot, String itemName){
        total -= itemCost;

        logOutput.println(dateTime + " " + itemName + " " + slot + " $" + itemCost + " $" + total);
        logOutput.flush();

        return total;

    }



    public double addMoney(int amount){

        total += amount;
        logOutput.println(dateTime + " FEED MONEY: $" + amount + " $" + total);
        logOutput.flush();
        return total;

    }
    public void giveChange(){
        logOutput.println(dateTime + " GIVE CHANGE: $" + total + " $0.00");
        logOutput.flush();

    }
}
