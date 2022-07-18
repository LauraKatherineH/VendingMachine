package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class TransactionsTest {
    Transactions PurchaseItemTest = new Transactions();

    public TransactionsTest() throws FileNotFoundException {
    }

    @Test
        public void purchaseItem_Test(){


            double testTotal = 50;
            double testItemCost = 10;
            double expected = 40;

            double actual = PurchaseItemTest.purchaseItem(testItemCost, testTotal, "A1", "Potato Crisps");

            Assert.assertEquals(expected, actual, 0);


        }
        @Test
    public void addMoney_Test(){

            int moneyAdded = 15;
            double expected = 15;

            double actual = PurchaseItemTest.addMoney(moneyAdded);

            Assert.assertEquals(expected, actual, 0);
        }
    }


//per Tom "FeedMoney class needs to be flushed out more but could be tested for
// if the current about is 0 and you add ten then total should equal ten

