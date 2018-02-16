package com.catalin.servers;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiClientServer {

  public static void main(String[] args) {
    int portNumber = 1122;
    boolean listening = true;

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
      while (listening) {
        executorService.execute(new MultiClientServerThread(serverSocket.accept()));
      }
    } catch (IOException e) {
      System.err.println("Could not listen on port " + portNumber);
      System.exit(-1);
    }
    executorService.shutdown();
  }

}
