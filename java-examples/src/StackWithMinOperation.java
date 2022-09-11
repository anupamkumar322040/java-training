import java.util.Stack;

class StackWithMinOperation
{
    private final Stack<Integer> stack;       // main stack to store elements
    private final Stack<Integer> auxiliaryStack;     // auxiliary stack to store minimum elements

    public StackWithMinOperation()
    {
        stack = new Stack<>();
        auxiliaryStack = new Stack<>();
    }

    // Inserts a given element on top of the stack
    public void push(int val)
    {
        // push the given element into the main stack
        stack.push(val);

        // if the auxiliary stack is empty, push the given element into it
        if (auxiliaryStack.isEmpty()) {
            auxiliaryStack.push(val);
        }
        else {
            // push the given element into the auxiliary stack
            // if it is less than or equal to the current minimum
            if (auxiliaryStack.peek() > val) {
                auxiliaryStack.push(val);
            }
        }
    }

    // Removes the top element from the stack and returns it
    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack underflow!!");
            System.exit(-1);
        }

        // remove the top element from the main stack
        int top = stack.pop();

        // remove the top element from the auxiliary stack
        // only if it is minimum
        if (top == auxiliaryStack.peek()) {
            auxiliaryStack.pop();
        }

        // return the removed element
        return top;
    }

    // Returns the top element of the stack
    public int top() {
        return stack.peek();
    }

    // Returns the total number of elements in the stack
    public int size() {
        return stack.size();
    }

    // Returns true if the stack is empty; false otherwise
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Returns the minimum element from the stack in constant time
    public int getMin()
    {
        if (auxiliaryStack.isEmpty())
        {
            System.out.println("Stack underflow!!");
            System.exit(-1);
        }

        return auxiliaryStack.peek();
    }

    public static void main (String[] args)
    {
        StackWithMinOperation s = new StackWithMinOperation();

        s.push(6);
        System.out.println(s.getMin());    // prints 6

        s.push(7);
        System.out.println(s.getMin());    // prints 6

        s.push(8);
        System.out.println(s.getMin());    // prints 6

        s.push(5);
        System.out.println(s.getMin());    // prints 5

        s.push(3);
        System.out.println(s.getMin());    // prints 3

        System.out.println(s.pop());    // prints 3
        System.out.println(s.getMin());    // prints 5

        s.push(10);
        System.out.println(s.getMin());    // prints 5

        System.out.println(s.pop());    // prints 10
        System.out.println(s.getMin());    // prints 5

        System.out.println(s.pop());    // prints 5
        System.out.println(s.getMin());    // prints 6
    }
}
