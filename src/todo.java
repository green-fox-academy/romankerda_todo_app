import com.greenfox.todoapp.Task;
import com.greenfox.todoapp.Usage;

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
        case "-a" -> addTask();
        default -> {
          System.out.println("\nInvalid argument\n");
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
      System.out.println("No todos for today! :)");
    } else {
      System.out.println("\nShort list of tasks");
      System.out.println("=".repeat(25) + "\n");
      System.out.println(list.printToDoListLong());
      System.out.println("=".repeat(25));
    }
  }

  public static void addTask() {
   if (arguments.length < 2) {
     System.out.println("\nUnable to add. No task provided\n");
   } else {
     Task newTask = new Task(arguments[1], false);
     list.addTask(newTask);
   }
  }



}
