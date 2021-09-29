package com.greenfox.todoapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {

  Task task1;
  Task task2;
  Task task3;
  ToDoList list;
  List<String> listForTests;

  @BeforeEach
  void setup() {
    task1 = new Task("Buy milk", false);
    task2 = new Task("Buy water", true);
    task3 = new Task("Walk the dog");
    listForTests = new ArrayList<>();
    list = new ToDoList(listForTests);
    list.addTask(task1);
    list.addTask(task2);
    list.addTask(task3);
  }

  @Test
  @DisplayName("Should print todo list correctly")
  void shouldPrintTodoListCorrectly() {
   String output = "1 - [ ] Buy milk\n 2 - [x] Buy water\n 3 - [ ] Walk the dog\n";
   assertEquals(output, list.printToDoListLong());

  }


}