class Node {

    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }
      
    public void setNext(Node node) {
        this.next = node;
    }
      
    public String getData() {
        return this.data;
    }
      
    public Node getNext() {
        return this.next;
    }
}


class LinkedList {

    private Node head;
    private Node tail;

    public Node getHead() {
        return this.head;
    }
      
    public Node getTail() {
        return this.tail;
    }

    public void addAtEnd(String data) {
        Node node = new Node(data);

        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            this.tail.setNext(node);

            this.tail = node;
        }
    }

    public void addAtBeginning(String data) {
        Node node = new Node(data);

        if (this.head == null) {
            this.head = this.tail = node;
        }

        else {
            node.setNext(this.head);
            this.head = node;
        }
    }

      public void display() {
        Node temp = this.head;

        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public Node find(String data) {
        Node temp = this.head;

        while (temp != null) {
            if (temp.getData().equals(data))
                return temp;
            temp = temp.getNext();
        }
        return null;
    }

    public void insert(String data, String dataBefore) {
        Node node = new Node(data);

        if (this.head == null)
            this.head = this.tail = node;
        else {
            Node nodeBefore = this.find(dataBefore);
            if (nodeBefore != null) {
                node.setNext(nodeBefore.getNext());
                nodeBefore.setNext(node);
                if (nodeBefore == this.tail)
                    this.tail = node;
            } 
            else
                System.out.println("Node not found");
        }
    }

    public void delete(String data) {

        if (this.head == null)
            System.out.println("List is empty");
        else {
            Node node = this.find(data);

            if (node == null)
                System.out.println("Node not found");

            if (node == this.head) {
                this.head = this.head.getNext();
                node.setNext(null);
          
                if (node == this.tail)
                    tail = null;
            }
            else {
                Node nodeBefore = null;
                Node temp = this.head;
                while (temp != null) {
                    if (temp.getNext() == node) {
                    nodeBefore = temp;
                    break;
                    }
                    temp = temp.getNext();
                }

                nodeBefore.setNext(node.getNext());
                      
                if (node == this.tail)
                    this.tail = nodeBefore;
                node.setNext(null);
            }
        }
    }
}


class Tester {

    public static void main(String args[]) {

        LinkedList linkedList = new LinkedList();
        LinkedList reversedLinkedList = new LinkedList();
            
        linkedList.addAtEnd("Data");
        linkedList.addAtEnd("Structures");
        linkedList.addAtEnd("and");
        linkedList.addAtEnd("Algorithms");
            
        System.out.println("Initial List");
        linkedList.display();
        System.out.println();
            
        Node originalHead = linkedList.getHead();
        Node reversedHead = reverseList(originalHead, reversedLinkedList);
        
        reversedLinkedList.setHead(reversedHead);
        
        System.out.println("Reversed List");
        reversedLinkedList.display();
    }

    public static Node reverseList(Node head, LinkedList reversedLinkedList) {
        // Base case: if head is null or only one node
        if (head == null || head.getNext() == null) {
            reversedLinkedList.setHead(head); // Set new head for reversed list
            return head;
        }

        // Recursively call reverseList to reverse the rest of the list
        Node newHead = reverseList(head.getNext(), reversedLinkedList);

        // Reverse the link
        head.getNext().setNext(head);
        head.setNext(null);

        return newHead; // Return the new head of the reversed list
    }
}
