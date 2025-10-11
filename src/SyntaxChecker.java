// You will need a functioning Stack implementation (like ArrayStack) for this to work.
// interface Stack { ... }
// class ArrayStack implements Stack { ... }

interface Stack<E> {
    void push(E item);
    E pop();
    boolean isEmpty();
}

class ArrayStack<E> implements Stack<E> {
    private Object[] data;
    private int top;

    public ArrayStack(int size) {
        if (size < 1) size = 1;
        data = new Object[size];
        top = 0;
    }

    public void push(E item) {
        if (top == data.length) {
            Object[] bigger = new Object[data.length * 2];
            System.arraycopy(data, 0, bigger, 0, data.length);
            data = bigger;
        }
        data[top++] = item;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        top--;
        E val = (E) data[top];
        data[top] = null;
        return val;
    }

    public boolean isEmpty() {
        return top == 0;
    }
}

public class SyntaxChecker {

    /**
     * Uses a stack to check if a line of code has balanced symbols.
     * @param line The string of code to check.
     * @return true if symbols are balanced, false otherwise.
     */
    public static boolean isBalanced(String line) {
        // TODO: Implement this method using a Stack.
        Stack buffer = new ArrayStack<>(line == null ? 0 : line.length());

        if (line == null) return true;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            // push opening symbols
            if (ch == '(' || ch == '{' || ch == '[') {
                buffer.push(Character.valueOf(ch));
            }
            // check closing symbols
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (buffer.isEmpty()) return false;
                char open = ((Character) buffer.pop()).charValue();
                if (!((open == '(' && ch == ')') ||
                        (open == '{' && ch == '}') ||
                        (open == '[' && ch == ']'))) {
                    return false;
                }
            }
            // ignore everything else
        }

        // balanced if nothing left on stack
        return buffer.isEmpty();
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}

