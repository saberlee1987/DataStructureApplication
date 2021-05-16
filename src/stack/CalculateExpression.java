package stack;

public class CalculateExpression {
    private int pos = -1;
    private int ch;

    private void nextChar(String input) {
        ch = (++pos < input.length()) ? input.charAt(pos) : -1;
    }

    private boolean eat(int charToEat, String input) {
        while (ch == ' ')
            nextChar(input);
        if (ch == charToEat) {
            nextChar(input);
            return true;
        }
        return false;
    }

    public double parse(String input) {
        nextChar(input);
        double x = parseExpression(input);
        if (pos < input.length()) throw new RuntimeException("Unexpected : " + (char) ch);
        return x;
    }

    private double parseExpression(String input) {
        double x = parseTerm(input);
        for (; ; ) {
            if (eat('+', input)) x += parseTerm(input);
            else if (eat('-', input)) x -= parseTerm(input);
            else return x;
        }
    }

    private double parseTerm(String input) {
        double x = parseFactor(input);
        for (; ; ) {
            if (eat('*', input)) x *= parseFactor(input);
            else if (eat('/', input)) x /= parseFactor(input);
            else return x;
        }
    }

    private double parseFactor(String input) {

        if (eat('+', input)) return parseFactor(input);
        if (eat('-', input)) return -parseFactor(input);

        double x;
        int startPos = this.pos;
        if (eat('(', input)) { // parentheses
            x = parseExpression(input);
            eat(')', input);
        } else if (eat('{', input)) {
            x = parseExpression(input);
            eat('}', input);
        } else if (eat('[', input)) {
            x = parseExpression(input);
            eat(']', input);
        } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
            while ((ch >= '0' && ch <= '9') || ch == '.') nextChar(input);
            x = Double.parseDouble(input.substring(startPos, this.pos));
        } else if (ch >= 'a' && ch <= 'z') { // functions
            while (ch >= 'a' && ch <= 'z') nextChar(input);
            String func = input.substring(startPos, this.pos);
            x = parseFactor(input);
            if (func.equals("sqrt")) x = Math.sqrt(x);
            else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
            else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
            else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
            else throw new RuntimeException("Unknown function: " + func);
        } else {
            throw new RuntimeException("Unexpected: " + (char) ch);
        }

        if (eat('^', input)) x = Math.pow(x, parseFactor(input)); // exponentiation

        return x;
    }
}
