import java.util.Stack;

class StackWithMinOperationNoSpace
{
    // main stack to store elements
    private final Stack<Integer> stack = new Stack<>();

    // variable to store the minimum element
    private int min;

    // Inserts a given element on top of the stack
    public void push(int val)
    {
        if (stack.empty())
        {
            stack.push(val);
            min = val;
        }
        else if (val > min) {
            stack.push(val);
        }
        else {
            stack.push(2*val - min);
            min = val;
        }
    }

    // Removes the top element from the stack
    public int pop()
    {
        if (stack.empty()) {
            System.out.println("Stack underflow!!");
            System.exit(-1);
        }

        int top = stack.pop();
        int oldMin = min;
        if (top < min) {
            min = 2*min - top;
        }
        return oldMin;
    }

    // Returns the minimum element from the stack in constant time
    public int getMin() {
        return min;
    }

    public static void main (String[] args)
    {
        StackWithMinOperationNoSpace s = new StackWithMinOperationNoSpace();
        s.push(12);
        System.out.println(s.getMin());
        s.push(13);
        System.out.println(s.getMin());
        s.push(8);
        System.out.println(s.getMin());
        s.push(-3);
        System.out.println(s.getMin());
        s.push(-7);
        System.out.println(s.getMin());
        s.push(-1);
        System.out.println(s.getMin());
        //pop
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
    }
}