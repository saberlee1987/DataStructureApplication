package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateExpression {
    private final List<Character> leftBrackets= Arrays.asList('{','[','(','<');
    private final List<Character> rightBrackets= Arrays.asList('}',']',')','>');


    public boolean evaluateExpresion(String input){

        Stack<Character> stack = new Stack<>();

        for (char ch: input.toCharArray()){

            if (isLeftBrackets(ch))
                stack.push(ch);

            if (isRightBrackets(ch)){
                if (stack.empty())
                    return false;
                char left= stack.pop();
                if (!bracketsMatch(left,ch))
                    return false;
            }
        }
        return true;
    }



    private  boolean isLeftBrackets(char ch){
        return leftBrackets.contains(ch);
    }

    private boolean isRightBrackets(char ch){
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right ){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
