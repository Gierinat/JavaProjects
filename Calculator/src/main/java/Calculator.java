import java.util.Scanner;

public class Calculator {

    static double result = 0;

    public Calculator() {

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello to Calculatorex");
        String userInputOption;
        do {
            System.out.println("Choose option number:\n" +
                    "1. Add\n" +
                    "2. Subtract\n" +
                    "3. Multiply\n" +
                    "4. Divide\n" +
                    "5. Clear Result\n" +
                    "6. Exit");

            userInputOption = scanner.nextLine();

            switch (userInputOption) {
                case "1": {
                    printForUser("Insert numbers separated by spaces to be added");
                    double[] input = getUserInput(scanner);

                    addInput(input);

                    printCurrentResult();
                    break;
                }
                case "2": {
                    printForUser("Insert numbers separated by spaces to be subtracted");
                    double[] input = getUserInput(scanner);

                    subtractInput(input);

                    printCurrentResult();
                    break;
                }
                case "3": {
                    printForUser("Insert numbers separated by spaces to be multiplied");
                    double[] input = getUserInput(scanner);

                    multiplyInput(input);

                    printCurrentResult();
                    break;
                }
                case "4": {
                    printForUser("Insert numbers separated by spaces to be divided");
                    double[] input = getUserInput(scanner);

                    divideInput(input);

                    printCurrentResult();
                    break;
                }
                case "5": {
                    result = 0;
                    printCurrentResult();
                    break;
                }
                default: {
                    System.out.println("No such option, please choose again.");
                    break;
                }
            }
        } while (!userInputOption.equals("6"));
    }

    private static boolean isZeroPresent(double[] input) {
        for (double number : input) {
            if (number == 0) {
                return true;
            }
        }
        return false;
    }

    private static void divideInput(double[] input) {

        if(isZeroPresent(input)) {
            System.out.println("Cannot divide by 0. Last instruction is ignored.");
        } else {
            for (int i = 0; i < input.length; i++) {
                result /= input[i];
            }
        }
    }

    private static void multiplyInput(double[] input) {
        for (int i = 0; i < input.length; i++) {
            result *= input[i];
        }
    }

    private static void subtractInput(double[] input) {
        for (int i = 0; i < input.length; i++) {
            result -= input[i];
        }
    }

    private static void addInput(double[] input) {
        for (int i = 0; i < input.length; i++) {
            result += input[i];
        }
    }

    private static void printForUser(String instruction) {
        printCurrentResult();
        System.out.println(instruction);
    }

    private static double[] getUserInput(Scanner scanner) {
        String userAnswer = scanner.nextLine();
        String[] split = userAnswer.split(" ");

        double[] input = new double[split.length];
        for (int i = 0; i < split.length; i++) {
            input[i] = Double.parseDouble(split[i]);
        }
        return input;
    }

    private static void printCurrentResult() {
        System.out.println("\nCurrent result: " + result + "\n");
    }
}
