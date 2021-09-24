package com.greenfox.todoapp;

public class Task {


  private boolean complete;
  private String description;

  public Task(String description) {
    this.description = description;
    complete = false;
  }

  public String printTask() {
    String status = "";
    if (complete) {
      status = "[x]";
    } else {
      status = "[ ]";
    }
    return status + " " + description;
  }

  public boolean isComplete() {
    return complete;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }

  public void setDescription(String description) {
    this.description = description;
  }


}
