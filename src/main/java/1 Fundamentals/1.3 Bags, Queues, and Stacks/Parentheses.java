import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {

    private static boolean isPair(char l, char r) {
        return (l == '(' && r == ')') || (l == '{' && r == '}' || l == '[' && r == ']');
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (!stack.isEmpty() && isPair(stack.peek(), str.charAt(i)))
                stack.pop();
            else stack.push(str.charAt(i));
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        In in = new In();
        String s = in.readAll().trim();
        StdOut.println(isBalanced(s));
    }
}
