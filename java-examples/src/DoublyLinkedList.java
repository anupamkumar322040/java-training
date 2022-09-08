public class DoublyLinkedList {
    Node head = new Node(10);
    Node curr = head;
    public void push(int newData)
    {
        Node newNode = new Node(newData);
        newNode.prev = head;
        newNode.next = null;
        if (head != null)
            head.next = newNode;
        head = newNode;
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

class Node{
    int data;
    Node prev;
    Node next;

    public Node(int data){
        this.data = data;
    }
}


/*
Insert next to given node data
Insert previous to given node data
A variation could be first or last node
Delete a given node
*/
