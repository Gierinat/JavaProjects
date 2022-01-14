import java.util.Scanner;

public class ToDoList {
    static ToDoItem[] toDoList = new ToDoItem[10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String menuChoice;

        System.out.print("Hello in To Do List!!!\n" +
                "Enjoy free trial and save up to 10 tasks.");

        do {
            displayToDoList();
            displayMenu();
            menuChoice = scanner.nextLine();

            switch (menuChoice) {
                case "1": {
                    addTask();
                    break;
                }
                case "2": {
                    editTask();
                    break;
                }
                case "3": {
                    removeTask();
                    break;
                }
                case "4": {
                    closeTask();
                    break;
                }
                case "5": {
                    reopenTask();
                    break;
                }
                default: {
                    System.out.println("No such option.\n");
                }
            }

        } while (!menuChoice.equals("6"));
    }

    private static void displayMenu() {
        System.out.println("Choose the option" +
                "\n 1. Add task" +
                "\n 2. Edit task" +
                "\n 3. Remove task" +
                "\n 4. Close task" +
                "\n 5. Reopen Task" +
                "\n 6. Exit");
    }

    private static void addTask() {
        int maxArrayIndex = toDoList.length - 1;

        if (toDoList[maxArrayIndex] == null) {
            System.out.println("Provide short task summary");
            String summary = scanner.nextLine();

            ToDoItem item = new ToDoItem(summary);
            addNextToList(toDoList, item);
        } else {
            System.out.println("Trial version allows to add up to 10 tasks. Remove tasks to add new ones.");
        }
    }

    private static void addNextToList(ToDoItem[] toDoList, ToDoItem item) {
        for (int i = 0; i < toDoList.length; i++) {
            if (toDoList[i] == null) {
                toDoList[i] = item;
                break;
            }
        }
    }

    private static void editTask() {

        System.out.println("Provide task number you want to edit");
        int taskNumber = getIntValue();

        if (taskExists(taskNumber)) {
            System.out.println("Provide new summary for task: " + taskNumber);
            String summary = scanner.nextLine();

            toDoList[taskNumber - 1].setSummary(summary);
        } else {
            System.out.println("Task does not exist.");
        }
    }

    private static void removeTask() {
        System.out.println("Provide task number you want to delete");
        int taskNumber = getIntValue();

        if (taskExists(taskNumber)) {

            for (int i = taskNumber - 1; i < toDoList.length - 1; i++) {
                toDoList[i] = toDoList[i + 1];
            }
            toDoList[toDoList.length - 1] = null;

        } else {
            System.out.println("Task does not exist.");
        }
    }

    private static void closeTask() {
        System.out.println("Provide task number you want to close");
        int taskNumber = getIntValue();

        if (taskExists(taskNumber)) {
            toDoList[taskNumber - 1].setDone();
        } else {
            System.out.println("Task does not exist.");
        }
    }

    private static void reopenTask() {
        System.out.println("Provide task number you want to reopen");
        int taskNumber = getIntValue();

        if (taskExists(taskNumber)) {
            toDoList[taskNumber - 1].setToDo();
        } else {
            System.out.println("Task does not exist.");
        }
    }

    private static boolean isTaskIndexInArray(int taskNumber) {
        int index = taskNumber - 1;
        for (int i = 0; i < toDoList.length; i++) {
            if (index == i) {
                return true;
            }
        }
        return false;
    }

    private static boolean taskExists(int taskNumber) {
        if (isTaskIndexInArray(taskNumber)) {
            int index = taskNumber - 1;
            if (toDoList[index] != null) {
                return true;
            }
        }
        return false;
    }

    private static int getIntValue() {
        int integer = 0;

        if (scanner.hasNextInt()) {
            integer = scanner.nextInt();
        }
        scanner.nextLine();
        return integer;
    }

    private static void displayToDoList() {
        System.out.println();

        int index = 1;
        for (ToDoItem item : toDoList) {

            if (item != null) {
                System.out.print(index + ". ");
                System.out.println(item);
                index++;
            }
        }
        System.out.println();
    }
}