package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalanceBrackets {
    public static void main(String[] args) {
        String s_1 = "}";
        boolean expected_1 = false;
        boolean output_1 = isBalanced(s_1);
        System.out.println(output_1);
    }

    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');

        for (Character ch : s.toCharArray()) {
            if (!stack.isEmpty() && ( ch == ')' || ch == '}' || ch == ']')) {
                Character current = stack.peek();
                if (ch.equals(brackets.get(current))) {
                    stack.pop();
                } else {
                    return false;
                }

            } else {
                stack.push(ch);
            }

        }


        return stack.isEmpty();

    }
}
