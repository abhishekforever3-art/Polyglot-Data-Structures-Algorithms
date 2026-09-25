import java.util.LinkedList;
import java.util.Deque;

public class Problem4_BankQueue {

    public void simulateQueue() {
        // Raw LinkedList used as a Deque (no generics)
        LinkedList queue = new LinkedList();

        System.out.println("--- 1. Regular Customers Arrive ---");
        queue.addLast("Customer 1 (Alice)");
        queue.addLast("Customer 2 (Bob)");
        queue.addLast("Customer 3 (Charlie)");
        System.out.println("Current Queue: " + queue);

        System.out.println("\n--- 2. VIP Customer Arrives ---");
        // VIP jumps straight to the front of the queue
        queue.addFirst("VIP Customer (Diana)");
        System.out.println("Current Queue: " + queue);

        System.out.println("\n--- 3. Bank Teller Serves Customers ---");
        
        // Peek at who is next at the front without removing
        String nextUp = (String) queue.peekFirst(); // Explicit cast
        System.out.println("Next customer to be served: " + nextUp);

        // Serve customers one by one from the front
        while (!queue.isEmpty()) {
            // Remove from the front of the queue
            String servedCustomer = (String) queue.removeFirst(); // Explicit cast
            System.out.println("Serving: " + servedCustomer);
            System.out.println("  Remaining Queue: " + queue);
        }
    }

    public static void main(String[] args) {
        Problem4_BankQueue bank = new Problem4_BankQueue();
        bank.simulateQueue();
    }
}