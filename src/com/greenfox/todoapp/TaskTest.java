package com.greenfox.todoapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
  Task task1;
  Task task2;
  Task task3;

  @BeforeEach
  void setup() {
    task1 = new Task("Buy milk", false);
    task2 = new Task("Buy water", true);
    task3 = new Task("Walk the dog");
  }

  @Test
  @DisplayName("Should print uncomplete task correctly")
  void shouldPrintUncompleteTaskCorrectly() {
    String output = "[ ] Buy milk\n";
    assertEquals(output, task1.printTask());
  }

  @Test
  @DisplayName("Should print complete task correctly")
  void shouldPrintCompleteTaskCorrectly() {
    String output = "[x] Buy water\n";
    assertEquals(output, task2.printTask());
  }

  @Test
  @DisplayName("Should return status of taks correctly")
  void shouldReturnStatusOfTaksCorrectly() {
    assertTrue(task2.isComplete());
    assertFalse(task1.isComplete());
  }

  @Test
  @DisplayName("Should set correct status")
  void shouldSetCorrectStatus() {
    task1.setComplete();
    assertTrue(task1.isComplete());
  }

  @Test
  @DisplayName("Should get correct description of task")
  void shouldGetCorrectDescriptionOfTask() {
    assertEquals("Buy milk", task1.getDescription());
  }

  @Test
  @DisplayName("Should instantiate task correctly")
  void shouldInstantiateTaskCorrectly() {
    assertEquals("Walk the dog", task3.getDescription());
    assertFalse(task3.isComplete());

  }





}