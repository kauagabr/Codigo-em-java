package atv_Estrutura_de_dados_2;
import java.util.Stack;

// Problema: Avaliar a validade de expressões matemáticas usando parênteses, colchetes e chaves.
// Explicação: Pilhas são úteis para rastrear a ordem de abertura e fechamento de símbolos, 
// 			   permitindo verificar a correspondência adequada.

public class Problema_1_Pilha {
	public static boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '[' && closing == ']') ||
               (opening == '{' && closing == '}');
    }

    public static void main(String[] args) {
        String expression = "{[()]}";
        System.out.println(isValidExpression(expression)); // Output: true

        expression = "{[(])}";
        System.out.println(isValidExpression(expression)); // Output: false
    }
}
