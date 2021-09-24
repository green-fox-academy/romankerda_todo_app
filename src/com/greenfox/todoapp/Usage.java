package com.greenfox.todoapp;

public class Usage {

  private static String[] argumentList = {
          "-l   List all the tasks",
          "-a   Add the new task",
          "-r   Remove the task",
          "-c   Complete the task"};

  public Usage() {}

  public void printUsage() {
    System.out.println("\nCommand Line ToDo Application");
    System.out.println("=".repeat(29) + "\n");
    System.out.println("Command line arguments:");
    for (int i = 0; i < argumentList.length; i++) {
      System.out.printf("  %s\n", argumentList[i]);
    }
    System.out.println();
  }
}
