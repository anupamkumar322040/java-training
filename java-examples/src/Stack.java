class Stack {
    private final int[] arr;
    private int top;
    private final int capacity;

    // Creating a stack
    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // push elements to the top of stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack OverFlow");
            // terminate the program
            System.exit(1);
        }

        // insert element on top of stack
        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    // pop elements from top of stack
    public int pop() {

        // if stack is empty
        // no element to pop
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
            // terminates the program
            System.exit(1);
        }
        // pop element from top of stack
        return arr[top--];
    }

    public int peek() {

        // if stack is empty
        // no element to peek
        if (isEmpty()) {
            System.out.println("STACK EMPTY");
        }
        // pop element from top of stack
        return arr[top];
    }

    // return size of the stack
    public int getSize() {
        return top + 1;
    }

    // check if the stack is empty
    public Boolean isEmpty() {
        return top == -1;
    }

    // check if the stack is full
    public Boolean isFull() {
        return top == capacity - 1;
    }

    // display elements of stack
    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.print("Stack: ");
        stack.printStack();

        int val = stack.peek();
        System.out.println("\n\nTop/peek value: "+val);
        System.out.println("After peek");
        stack.printStack();

        // remove element from stack
        int val2 = stack.pop();
        System.out.println("\n\nPopped value: "+val2);
        System.out.println("After popping out");
        stack.printStack();
    }
}