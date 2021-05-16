package stack;

public class EvaluateExpresionTest {
    public static void main(String[] args) {
      EvaluateExpression expresion = new EvaluateExpression();
      boolean result =expresion.evaluateExpresion("(([[{{(({{}}))}}]]))");
        System.out.println(result);

    }
}
