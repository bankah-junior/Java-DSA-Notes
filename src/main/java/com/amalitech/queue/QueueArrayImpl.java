package com.amalitech.queue;

public class QueueArrayImpl {
    int queueLength = 4;
    int[] items = new int[queueLength];
    int front = -1;
    int back = -1;

    boolean isFull(){
        return back == queueLength - 1;
    }

    boolean isEmpty(){
        return front == -1 && back == -1;
    }

    void enQueue(int itemValue) {
        if(isFull()){
            System.out.println("Queue is full");
        } else if(isEmpty()){
            front = back = 0;
            items[back] = itemValue;
        } else{
            back++;
            items[back] = itemValue;
        }
    }

    void deQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty. Nothing to dequeue");
        } else if (front == back){
            front = back = -1;
        } else {
            front++;
        }
    }

    void display(){
        int i;

        if(isEmpty()){
            System.out.println("Queue is empty");
        } else {
            for(i = front; i <= back; i++){
                System.out.println(items[i]);
            }
        }
    }

    void peak(){
        System.out.println("Front value is: " + items[front]);
    }

    public static void main(String[] args) {
        QueueArrayImpl q = new QueueArrayImpl();

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);

        q.display();

        q.peak();

        q.deQueue();
        q.deQueue();
        System.out.println("After two dequeues");

        q.display();

        q.peak();
    }
}