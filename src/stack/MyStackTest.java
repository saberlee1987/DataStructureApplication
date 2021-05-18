package stack;

import java.util.Scanner;

public class MyStackTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the n : ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String statement = "";
        MyStack stack = new MyStack();
        for (int i = 0; i < n; i++) {
            System.out.print("enter the statement " + (i + 1) + " :");
            statement = scanner.nextLine();
            String[] line = statement.trim().split("\\s+");

            boolean isValid = validate(line);

            if (!isValid) {
                System.out.println("please enter correct statement");
            } else {
                switch (line[0].trim().toLowerCase()) {
                    case "push":
                        stack.push(Integer.parseInt(line[1].trim()));
                        break;
                    case "pop":
                        try {
                            System.out.println(stack.pop());
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    default:
                        System.out.println("please enter correct statement");
                }
            }
        }
    }


    private static boolean validate(String[] line) {
        boolean isValid = true;

        if (line.length == 0) {
            isValid = false;
        } else if (line.length > 2) {
            isValid = false;
        } else if ((line[0].trim().toLowerCase().equals("push") && line.length == 1) ||
                (line[0].trim().toLowerCase().equals("push") && !line[1].trim().matches("\\d+"))) {
            isValid = false;
        }
        return isValid;
    }
}
