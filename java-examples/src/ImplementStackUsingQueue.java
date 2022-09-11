import java.util.ArrayDeque;
import java.util.Queue;

// Implement stack using two queues
class ImplementStackUsingQueue
{
    Queue<Integer> q1, q2;

    // Constructor
    public ImplementStackUsingQueue()
    {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    // Insert an item into the stack
    void add(int data)
    {
        // Move all elements from the first queue to the second queue
        while (!q1.isEmpty())
        {
            q2.add(q1.poll());
        }

        // Push the given item into the first queue
        q1.add(data);

        // Move all elements back to the first queue from the second queue
        while (!q2.isEmpty())
        {
            q1.add(q2.poll());
        }
    }

    // Remove the top item from the stack
    public int poll()
    {
        // if the first queue is empty
        if (q1.isEmpty())
        {
            System.out.println("Underflow!!");
            System.exit(0);
        }

        // return the front item from the first queue
        return q1.poll();
    }

    public static void main(String[] args)
    {
        int[] keys = { 10, 12, 23, 44, 56 };

        // insert the above keys into the stack
        ImplementStackUsingQueue s = new ImplementStackUsingQueue();
        for (int key: keys) {
            s.add(key);
        }

        for (int i = 0; i <= keys.length; i++) {
            System.out.println(s.poll());
        }
    }
}
