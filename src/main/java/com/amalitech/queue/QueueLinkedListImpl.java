package com.amalitech.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedListImpl {
    public static void main(String[] args) {
        Queue<String> myQueue = new LinkedList<>();

        // Add elements to the queue (enqueue)
        myQueue.offer("Apple");
        myQueue.offer("Banana");
        myQueue.offer("Cherry");

        System.out.println("Queue: " + myQueue); // Output: Queue: [Apple, Banana, Cherry]

        // Peek at the front element
        String frontElement = myQueue.peek();
        System.out.println("Front element: " + frontElement); // Output: Front element: Apple

        // Remove elements from the queue (dequeue)
        String removedElement = myQueue.poll();
        System.out.println("Removed element: " + removedElement); // Output: Removed element: Apple
        System.out.println("Queue after poll: " + myQueue); // Output: Queue after poll: [Banana, Cherry]

        // Check if the queue is empty
        boolean isEmpty = myQueue.isEmpty();
        System.out.println("Is queue empty? " + isEmpty); // Output: Is queue empty? false
    }
}