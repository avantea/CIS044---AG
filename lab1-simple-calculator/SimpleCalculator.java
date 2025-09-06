import java.util.Scanner;

public class SimpleCalculator {

    // Attributes
    private double currentValue = 0;
    private String operator = "";
    private boolean firstNumber = true;

    // Main method
    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();
        calc.run();
    }

    // Method for calculator loop so it makes continuous calculations
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Simple Calculator (+, -, *, /, =). Type 'clear' to reset, 'quit' or 'exit' to exit.");

        while (true) {
            System.out.println("");
            System.out.print(" Input: ");
            String input = scanner.nextLine().trim(); // trim removes whitespace from both ends of a string
            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.out.print("Calculator closed!");
                break;
            }

            if (input.equalsIgnoreCase("clear")) { // same thing as the above line
                reset();
                continue;
            }

            if (input.matches("-?\\d+(\\.\\d+)?")) {
                double number = Double.parseDouble(input);
                processNumber(number);
            } else if (input.matches("[+\\-*/=]")) {
                processOperator(input);
            } else {
                System.out.println("Invalid!!! Enter a number, operator, 'clear', or 'exit'.");
            }
        }

        scanner.close();
    }

    // Method to accept numbers and operators
    private void processNumber(double number) {
        if (firstNumber) {
            currentValue = number;
            firstNumber = false;
        }
        else {
            switch (operator) {
                case "+": currentValue += number; break;
                case "-": currentValue -= number; break;
                case "*": currentValue *= number; break;
                case "/":
                    if (number == 0) {
                        System.out.println("Error: Cannot divide by 0!");
                    } else {
                        currentValue /= number;
                    }
                    break;
                default:
                    System.out.println("No operator selected yet?");
                    return;
            }
        }
        System.out.println("Display: " + currentValue);
    }

    // Method to process the operator chosen
    private void processOperator(String op) {
        if (op.equals("=")) {
            System.out.println("Answer: " + currentValue);
        }
        else {
            this.operator = op;
            System.out.println("Operator chosen: " + operator);
        }
    }

    // Method to reset calculator
    private void reset() {
        currentValue = 0;
        operator = "";
        firstNumber = true;
        System.out.println("Calculator reset!");
    }

}







