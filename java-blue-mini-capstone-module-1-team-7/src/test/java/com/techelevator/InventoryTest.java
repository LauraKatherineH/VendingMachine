package com.techelevator;

import org.junit.Test;

import static java.lang.Double.parseDouble;
import static org.junit.Assert.*;

public class InventoryTest {

    Inventory ListTestInventory = new Inventory();
    @Test
    public void InventoryTest_Test_Size() {

        //Arrange


        //Assert
        //Good Parties
        assertEquals(16, ListTestInventory.inventoryList().size());
    }

//        @Test
//                public void InventoryTest_List_Test(){
//        assertSame(ListTestInventory.inventoryList().get(ListTestInventory.inventoryList()), "A1");

        //String[] splitItem = item.split("\\|");

       // if (splitItem[3].equals("Candy")) {
         //   inventory.put(splitItem[0], new CandyItems(splitItem[1], parseDouble(splitItem[2]), 5));
        }

//A1|Potato Crisps|3.05|Chip
//0   1              2   3
//test is AI is equal to string Potato Crisps