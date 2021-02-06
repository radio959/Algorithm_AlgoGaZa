import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static int length;
    private static char[] chars;
    private static String prefix;
    private static Stack<Character> stack;
    private static Stack<Integer> number_stack;

    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= 10; t++) {
            STRING_BUILDER.setLength(0);
            STRING_BUILDER.append("#").append(t).append(" ");
            length = Integer.parseInt(BUFFERED_READER.readLine().trim());
            stack = new Stack<>();
            number_stack = new Stack<>();
            prefix = "";
            chars = BUFFERED_READER.readLine().toCharArray();
            makePrefix();
            STRING_BUILDER.append(makeResult());
            System.out.println(STRING_BUILDER.toString());
        }

    }

    private static void makePrefix() {
        for (int i = 0; i < chars.length; i++) {
            if (0 <= chars[i] - '0' && chars[i] - '0' <= 9) {
                prefix += chars[i] + "";
                continue;
            }
            if (stack.isEmpty()) {
                stack.add(chars[i]);
                continue;
            }
            if (stack.peek() == '+' && chars[i] == '*') {
                stack.add(chars[i]);
                continue;
            }

            if (stack.peek() == '*' && chars[i] == '*') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '+') break;
                    prefix += stack.pop() + "";
                }
                stack.add('*');
                continue;
            }

            if (chars[i] == '+') {
                while (!stack.isEmpty()) {
                    prefix += stack.pop() + "";
                }
                stack.add('+');
                continue;
            }
        }
        while (!stack.isEmpty()) {
            prefix += stack.pop() + "";
        }
    }


    private static int makeResult() {
        for (int i = 0; i < prefix.length(); i++) {
            if (0 <= prefix.charAt(i) - '0' && prefix.charAt(i) - '0' <= 9) {
                number_stack.add(prefix.charAt(i) - '0');
                continue;
            }
            int n1 = number_stack.pop();
            int n2 = number_stack.pop();
            int result = 0;
            switch (prefix.charAt(i)) {
                case '*':
                    result = n1 * n2;
                    break;
                case '+':
                    result = n1 + n2;
                    break;
            }
            number_stack.add(result);
        }
        return number_stack.pop();
    }

}
