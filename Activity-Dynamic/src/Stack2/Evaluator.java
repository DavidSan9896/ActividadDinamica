package Stack2;
import java.util.Stack;

public class Evaluator {
    public static double evaluateExpression(String expression) {
        // Eliminar espacios en blanco de la expresión
        expression = expression.replaceAll("\\s+", "");

        // Inicializar la pila
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                // extraer el número completo si es dijito
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numBuilder.append(expression.charAt(i));
                    i++;
                }
                i--;
                // Agregar el número a la pila
                values.push(Double.parseDouble(numBuilder.toString()));
            } else if (ch == '(') {
                // Si es un paréntesis de apertura, agregarlo a la pila de operadores
                operators.push(ch);
            } else if (ch == ')') {
                // Si es un paréntesis de cierre, evaluar las operaciones dentro del paréntesis
                while (!operators.isEmpty() && operators.peek() != '(') {
                    double result = applyOperator(operators.pop(), values.pop(), values.pop());
                    values.push(result);
                }
                operators.pop(); // Sacar el paréntesis de apertura de la pila de operadores
            } else if (isOperator(ch)) {
                // Si es un operador evaluar operaciones con operadores de mayor o igual
                while (!operators.isEmpty() && operators.peek() != '(' && hasHigherPrecedence(operators.peek(), ch)) {
                    double result = applyOperator(operators.pop(), values.pop(), values.pop());
                    values.push(result);
                }
                operators.push(ch);
            }
        }
        // Evaluar las operaciones restantes en la pila
        while (!operators.isEmpty()) {
            double result = applyOperator(operators.pop(), values.pop(), values.pop());
            values.push(result);
        }
        // El valor en la cima de la pila es el resultado final
        return values.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static boolean hasHigherPrecedence(char op1, char op2) {
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }

    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operator);
        }
    }
}

