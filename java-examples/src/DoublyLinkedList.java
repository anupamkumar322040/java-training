public class DoublyLinkedList {
    Node1 head = new Node1(10);
    Node1 curr = head;
    public void push(int newData)
    {
        Node1 newNode1 = new Node1(newData);
        newNode1.prev = head;
        newNode1.next = null;
        if (head != null)
            head.next = newNode1;
        head = newNode1;
    }

    public void display()
    {
        System.out.print("null <-> ");
        while (curr!=null){
            System.out.print(curr.data+" <-> ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.push(12);
        doublyLinkedList.push(13);
        doublyLinkedList.push(14);
        doublyLinkedList.push(15);
        doublyLinkedList.display();
    }
}

class Node1{
    int data;
    Node1 prev;
    Node1 next;

    public Node1(int data){
        this.data = data;
    }
}


/*
Insert next to given node1 data
Insert previous to given node1 data
A variation could be first or last node1
Delete a given node1
*/
