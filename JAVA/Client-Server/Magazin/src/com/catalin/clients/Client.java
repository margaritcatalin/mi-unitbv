package com.catalin.clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
  public static void main(String[] args) {
    String hostName = "127.0.0.1";
    int portNumber = 1122;

    try (Socket clientSocket = new Socket(hostName, portNumber);
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

      BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
      String fromServer;

      printNotLoggedMenu();
      String currentUserType = "";

      while ((fromServer = in.readLine()) != null) {
        System.out.println("Server: " + fromServer);
        if (fromServer.equals("EXIT")) {
          break;
        }
        if(fromServer.equalsIgnoreCase("Password not matching!") ||
            fromServer.equalsIgnoreCase("User already exists.")){
          printNotLoggedMenu();
          readUserInput(stdIn,out);
        } else if (fromServer.equalsIgnoreCase("Wrong username or password.")) {
          printNotLoggedMenu();
          readUserInput(stdIn,out);
        } else if(fromServer.equalsIgnoreCase("Successfully logged in.buyer")){
          System.out.println("Buyer is now logged.");
          currentUserType = "buyer";
          printLoggedMenu(currentUserType);
          readUserInput(stdIn,out);
        }else if(fromServer.equalsIgnoreCase("Aceasta optiune nu exista!")) {
        	printLoggedMenu(currentUserType);
        	readUserInput(stdIn,out);
        } else if(fromServer.equalsIgnoreCase("Successfully logged in.seller")){
          System.out.println("Seller is now logged.");
          currentUserType = "seller";
          printLoggedMenu(currentUserType);
          readUserInput(stdIn,out);
        } else if(fromServer.equalsIgnoreCase("The operation was successful.")){
            printLoggedMenu(currentUserType);
            readUserInput(stdIn,out);
        } else if (fromServer.equalsIgnoreCase("checking...")) {

        } else if(fromServer.equalsIgnoreCase("logged out")){
          printNotLoggedMenu();
          readUserInput(stdIn,out);
        } else if(fromServer.equalsIgnoreCase("Wrong old password!") ||
              fromServer.equalsIgnoreCase("New password not matching!") ||
              fromServer.equalsIgnoreCase("Password successfully changed.")){
          printLoggedMenu(currentUserType);
          readUserInput(stdIn,out);
        } else if(fromServer.equalsIgnoreCase("Successfully created account.")) {
          printNotLoggedMenu();
          readUserInput(stdIn,out);
        } else {
          readUserInput(stdIn,out);
        }

      }
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host " + hostName);
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to " + hostName);
      System.exit(1);
    }
  }

  private static void readUserInput(BufferedReader stdIn,PrintWriter out) throws IOException {
    String fromUser = stdIn.readLine();
    if(fromUser != null){
      System.out.println("Client: " + fromUser);
      out.println(fromUser);
    }
  }
  public static void printNotLoggedMenu() {
    System.out.println("Enter \'signup\' to create account.");
    System.out.println("Enter \'login\' for logIn.");
    System.out.println("Enter \'exit\' to quit.");
  }

  public static void printLoggedMenu(String userType){
    switch (userType){
      case "buyer":{
        System.out.println("Enter \'seeAllProducts\' to see products list.");
        System.out.println("Enter \'search\' to search a product by its code or name.");
        System.out.println("Enter \'buy\' to buy a product.");
        System.out.println("Enter \'orders\' to see your shopping cart.");
        System.out.println("Enter \'balance\' to see your balance.");
        break;
      }
      case "seller":{
        System.out.println("Enter \'seeProducts\' to see your products.");
        System.out.println("Enter \'addProduct\' to add a product.");
        break;
      }
    }
    System.out.println("Enter \'change password\' to change your password.");
    System.out.println("Enter \'logout\' to log out.");
    System.out.println("Enter \'exit\' to quit.");
  }
}
