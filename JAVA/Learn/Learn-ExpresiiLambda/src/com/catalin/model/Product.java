package com.catalin.model;

import java.util.Comparator;
public class Product {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void printProduct() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
     return "Product [name=" + name + ", price=" + price + "]";
    }

    public static Comparator 
     ascendingPrice = (p1, p2) -> {
      return ((Product) p1).getPrice() - ((Product) p2).getPrice();
    };

    public static Comparator 
     descendingPrice = (p1, p2) -> {
      return ((Product) p2).getPrice() - ((Product) p1).getPrice();
    };
}
