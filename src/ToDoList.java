import com.greenfox.todoapp.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {

 private List<Task> toDoList;
 private static String file = "com/greenfox/todoapp/todolist.csv";


  public ToDoList() {
    toDoList = new ArrayList<>();
    toDoList = readToDoList(file);
  }


  private List<Task> readToDoList(String file) {
    List<String> fileLines = new ArrayList<>();
    try {
      fileLines = Files.readAllLines(Paths.get(file));
    } catch (IOException e) {
      System.out.println("Can't read file 'todolist.csv'");
    }
    for (int i = 0; i < fileLines.size(); i++) {
      String[] taskData = fileLines.get(i).split(",   ");
      boolean taskStatus = taskData[1].equals("true") ? true : false;
      Task task = new Task(taskData[0], taskStatus);
      toDoList.add(task);
    }
    return toDoList;
  }

  public String printToDoListShort() {
    StringBuilder shortList = new StringBuilder();
    for (int i = 0; i < toDoList.size(); i++) {
      shortList.append(i+1 + " - " + toDoList.get(i).getDescription() + "\n");
    }
    return shortList.toString();
  }

  public String printToDoListLong() {
    StringBuilder longList = new StringBuilder();
    for (int i = 0; i < toDoList.size(); i++) {
      if (i < 9) {
        longList.append(" " + (i + 1) + " - " + toDoList.get(i).printTask());
      }
      else {
        longList.append(i + 1 + " - " + toDoList.get(i).printTask());
      }
    }
    return longList.toString();
  }

  public List<Task> getToDoList() {
    return toDoList;
  }

  public void addTask(Task task) {
    toDoList.add(task);
    this.updateFile();
  }

  public void updateFile() {
    List<String> lines = new ArrayList<>();
    for (int i = 0; i < toDoList.size(); i++) {
      String line = toDoList.get(i).getDescription() + ",   " + toDoList.get(i).isComplete();
      lines.add(line);
    }
    try {
      Files.write(Paths.get(file), lines);
    } catch (IOException e) {
      System.out.println("Can't write file");
    }

  }

}

