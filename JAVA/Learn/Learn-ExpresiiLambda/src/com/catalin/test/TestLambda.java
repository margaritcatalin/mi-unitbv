package com.catalin.test;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

import com.catalin.model.Product;

public class TestLambda {

	  public static void processProducts(
	    Set<Product> products, Consumer block) {
	      for (Product p : products) {
	             block.accept(p);
	      }
	  }

	  public static void main(String[] args) {

	    Product p1 = new Product();
	    p1.setName("onion");
	    p1.setPrice(10);
	    Product p2 = new Product();
	    p2.setName("tomato");
	    p2.setPrice(20);

	    Set ascendingPriceProducts = new TreeSet<>(Product.ascendingPrice);

	    ascendingPriceProducts.add(p1);
	    ascendingPriceProducts.add(p2);

	    System.out.println("In ascending order:");
	    processProducts(ascendingPriceProducts, p -> ((Product) p).printProduct());

	    Set descendingPriceProducts = new TreeSet<>(Product.descendingPrice);

	    descendingPriceProducts.add(p1);
	    descendingPriceProducts.add(p2);

	    System.out.println("In descending order:");
	    processProducts(descendingPriceProducts, p -> ((Product) p).printProduct());

	  }
	}