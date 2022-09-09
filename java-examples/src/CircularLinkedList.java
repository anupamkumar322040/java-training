public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        tail.next = head;
    }

    public void display(){
        Node curr = head;
        if(head!=null){
            do{
                System.out.print(curr.data+" -> ");
                curr = curr.next;
            }
            while(curr!=head);
        }
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.addNode(10);
        circularLinkedList.addNode(11);
        circularLinkedList.addNode(12);
        circularLinkedList.addNode(13);
        circularLinkedList.addNode(14);
        circularLinkedList.addNode(15);
        circularLinkedList.display();
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}

/* Search, Update, Delete */
