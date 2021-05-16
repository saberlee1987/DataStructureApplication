package stack;

public class CalculateExpressionTest{
    public static void main(String[] args) {
        CalculateExpression expression  = new CalculateExpression();
        double result =expression.parse("(25 + ( 4 * { 5 * {7 + 8 } +3 } *3 ) +12 )");
        System.out.println(result);
    }
}
