package com.catalin.protocols;

import com.catalin.utils.States;

public class UserProtocol {

  private States state = States.WAITING;

  public States getState(){
    return state;
  }

  public String processInput(String theInput) {
    String theOutput = null;

    switch (state) {
      case WAITING: {
        theOutput = "Choose option.";
        state = States.NOTLOGGED;
        break;
      }
      case LOGGING: {
        switch (theInput.toLowerCase()) {
          case "username_entered": {
            theOutput = "Please type your password:";
            break;
          }
          case "password_entered": {
            theOutput = "Checking...";
            state = States.CHECKING;
            break;
          }
        }
        break;
      }
      case CHECKING:{
        switch (theInput.toLowerCase()){
          case "unsuccessful":{
            theOutput = "Wrong username or password.";
            state = States.NOTLOGGED;
            break;
          }
          case "successful":{
            theOutput = "Successfully logged in.";
            state = States.LOGGED;
            break;
          }
        }
        break;
      }
      case NOTLOGGED: {
        switch (theInput.toUpperCase()) {
          case "EXIT": {
            theOutput = "EXIT";
            break;
          }
          case "LOGIN": {
            theOutput = "Please type your username:";
            state = States.LOGGING;
            break;
          }
          case "SIGNUP":{
            theOutput = "Please enter the username:";
            state = States.SIGNUP;
            break;
          }
          default:
            theOutput = "Choose option.";
            break;
        }
        break;
      }
      case SIGNUP:{
        switch (theInput){
          case "username_entered":{
            theOutput = "Please type your password:";
            break;
          }
          case "password_entered":
          {
            theOutput = "Re-enter password:";
            break;
          }
          case "password_reentered":{
            theOutput = "Do you want to be a seller?(yes/no):";
            state = States.NOTLOGGED;
            break;
          }
        }
        break;
      }
      case LOGGED:{
        switch (theInput.toUpperCase()){
          case "EXIT": {
            theOutput="EXIT";
            break;
          }
          case "LOGOUT":{
            theOutput = "Logged Out";
            state = States.NOTLOGGED;
            break;
          }
          default:{
            theOutput = "Getting results.";
            break;
          }
        }
        break;
      }
      default:
        break;
    }

    return theOutput;
  }
}
