package algorithm;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
         String input = ")()())";
        //String input = "()(()";
        // String input = "";
        System.out.println(longestValidParentheses(input));
    }

    static public int longestValidParentheses(String s) {
        int maxCount = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.peek()>=0 && s.charAt(stack.peek())=='(') {
                stack.pop();
                maxCount = Math.max(maxCount, i - stack.peek());
            }else{
                stack.push(i);
            }

        }


        return maxCount;


    }


}
