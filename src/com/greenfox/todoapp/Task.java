package com.greenfox.todoapp;

public class Task {


  private boolean complete;
  private String description;

  public Task(String description) {
    this.description = description;
    complete = false;
  }

  public Task(String description, boolean complete) {
    this.complete = complete;
    this.description = description;
  }

  public String printTask() {
    String status = "";
    if (complete) {
      status = "[x]";
    } else {
      status = "[ ]";
    }
    return status + " " + description + "\n";
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

  public String getDescription() {
    return description;
  }


}
