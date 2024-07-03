import java.util.LinkedList;
import java.util.List;

class Tester {

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue("Emily");
        queue.enqueue("Lily");
        queue.enqueue("Rachel");
        queue.enqueue("Rose");

        queue.dequeue();
        queue.dequeue();

        System.out.println(queue.getQueue()); // Output: [Rachel, Rose]
    }
}

class Queue {
    private LinkedList<String> queue;
    private int maxSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new LinkedList<>();
    }

    public void enqueue(String item) {
        if (queue.size() < maxSize) {
            queue.addLast(item);
        } else {
            System.out.println("Queue is full, cannot enqueue " + item);
        }
    }

    public String dequeue() {
        if (!queue.isEmpty()) {
            return queue.removeFirst();
        } else {
            System.out.println("Queue is empty, cannot dequeue");
            return null;
        }
    }

    public List<String> getQueue() {
        return queue;
    }
}
