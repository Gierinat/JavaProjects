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
                default: {
                    System.out.println("No such option.\n");
                }
            }

        } while (!menuChoice.equals("5"));
    }

    private static void displayMenu() {
        System.out.println("Choose the option" +
                "\n 1. Add task" +
                "\n 2. Edit task" +
                "\n 3. Remove task" +
                "\n 4. Close task" +
                "\n 5. Exit");
    }

    private static void addTask() {
        System.out.println("Provide short task summary");
        String summary = scanner.nextLine();
        ToDoItem item = new ToDoItem(summary);
        addNextToList(toDoList, item);
    }
//TODO Let user know one the list limitation
    private static void addNextToList(ToDoItem[] toDoList, ToDoItem item) {
        for (int i = 0; i < toDoList.length; i++) {
            if (toDoList[i] == null) {
                toDoList[i] = item;
                break;
            }
        }
    }
//TODO handle editing nonexisting item
    private static void editTask() {
        System.out.println("Provide task number you want to edit");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Provide new summary for task: " + taskNumber);
        String summary = scanner.nextLine();

        toDoList[taskNumber - 1].setSummary(summary);
    }
//TODO handle removing nonexisting item
    private static void removeTask() {
        System.out.println("Provide task number you want to delete");
        int taskNumber = scanner.nextInt();
        scanner.nextLine();

        ToDoItem item = toDoList[taskNumber - 1];

        if (item != null) {
            for (int i = taskNumber - 1; i < toDoList.length - 1; i++) {
                toDoList[i] = toDoList[i + 1];
            }
            toDoList[toDoList.length - 1] = null;

        } else {
            System.out.println("No such task.");
        }
    }

    private static void closeTask() {
        System.out.println("Provide task number you want to close");
        int taskNumber = scanner.nextInt();
        toDoList[taskNumber - 1].setDone(true);
    }

    private static void displayToDoList() {

        System.out.println();
//TODO for each loop
        for (int i = 0; i < toDoList.length; i++) {
            ToDoItem item = toDoList[i];

            if (item != null) {
                System.out.print(i + 1 + ". ");
                item.printTask();
            }
        }
        System.out.println();
    }
}