package com.techelevator;



public class Items  {
    private double price;
    private int productStock;
    private String name;

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getName() {
        return name;
    }

    public int getProductStock() {
        return productStock;
    }

    public double getPrice() {
        return price;
    }

    public Items(String name, double price, int productStock) {
        this.price = price;
        this.productStock = productStock;
        this.name = name;
    }

    public Items() {

    }


    @Override
    public String toString() {
        return  " " + name + " $" + price + " " + "Current Stock amount: " + productStock;
    }
    public String toStringSelectedItem(){
        return name + " $" + price;
    }



}
