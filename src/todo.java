import com.greenfox.todoapp.Task;
import com.greenfox.todoapp.ToDoList;
import com.greenfox.todoapp.Usage;

import static java.lang.Integer.parseInt;

public class todo {

 private static ToDoList list;
 private static String[] arguments;
 private static Usage usage;


  public static void main(String[] args) {
    list = new ToDoList();
    arguments = args;
    if (args.length > 0) {
      switch (args[0]) {
        case "-l" -> printList();
        case "-a" -> {
          addTask();
          printList();
        }
        case "-r" -> {
          removeTask();
          printList();
        }
        case "-c" -> {
          checkTask();
          printList();
        }
        default -> {
          System.out.println("\nUnsupported argument\n");
          printUsage();
        }
      }
    } else {
      printUsage();
    }
  }

  public static void printUsage() {
    usage = new Usage();
    usage.printUsage();
  }

  public static void printList() {
    if (list.getToDoList().size() == 0) {
      System.out.println("\nNo todos for today! :)\n");
    } else {
      System.out.println("\nList of tasks");
      System.out.println("=".repeat(25) + "\n");
      System.out.println(list.printToDoListLong());
      System.out.println("=".repeat(25));
    }
  }

  public static void addTask() {
   if (arguments.length < 2) {
     System.out.println("\nUnable to add: no task provided\n");
   } else {
     Task newTask = new Task(arguments[1], false);
     list.addTask(newTask);
   }
  }

  public static void removeTask() {
    if (arguments.length < 2) {
      System.out.println("\nUnable to remove: no index provided\n");
    } else if (!isInt(arguments[1])) {
      System.out.println("\nUnable to remove: index is not a number\n");
    } else if (parseInt(arguments[1]) > list.getSize() || parseInt(arguments[1]) < 1) {
      System.out.println("\nUnable to remove: index is out of bound\n");
    } else {
      list.removeTask(parseInt(arguments[1]));
    }
  }

  public static boolean isInt(String input){
    try {
      parseInt(input);
    } catch(Exception e) {
      return false;
    }
    return true;
  }

  public static void checkTask() {
    if (arguments.length < 2) {
      System.out.println("\nUnable to check: no index provided\n");
    } else if (!isInt(arguments[1])) {
      System.out.println("\nUnable to check: index is not a number\n");
    } else if (parseInt(arguments[1]) > list.getSize() || parseInt(arguments[1]) < 1) {
      System.out.println("\nUnable to check: index is out of bound\n");
    } else {
      list.getTask(parseInt(arguments[1])).setComplete();
      list.updateFile();
    }
  }
}
