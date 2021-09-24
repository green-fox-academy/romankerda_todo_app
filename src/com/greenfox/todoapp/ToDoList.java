package com.greenfox.todoapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {

 private List<Task> toDoList;


  public ToDoList() {
    toDoList = readFile("todolist.csv");

  }




  private static List<Task> readFile(String file) {
    try {
      List<String> fileLines = Files.readAllLines(Paths.get(file));
    } catch (IOException e) {
      System.out.println("Can't read file 'todolist.csv'");
    }
    
  }
}
