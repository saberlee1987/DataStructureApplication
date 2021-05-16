package stack;

import java.util.Stack;

public class StackReverseTest {

    public static void main(String[] args) {
        String input = "abcdefgh";
        System.out.println(input);
        System.out.println(reverse(input));
    }

    private static String reverse(String input){
        if (input == null)
            throw new IllegalArgumentException();


        StringBuilder stringBuffer = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (char ch: input.toCharArray())
            stack.push(ch);

        while (!stack.empty())
            stringBuffer.append(stack.pop());

        return stringBuffer.toString();
    }
}
