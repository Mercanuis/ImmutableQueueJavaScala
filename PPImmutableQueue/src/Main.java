import Queue.IQueue;
import Queue.ImmutableQueue;

import java.util.NoSuchElementException;

/**
 * This class fills an immutable queue and then de-queues it
 *
 * @author Joey Orme
 */
public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Hi there");
            IQueue<Integer> intQueue = ImmutableQueue.getNewQueue();
            intQueue = intQueue.enqueue(1);
            intQueue = intQueue.enqueue(2);
            intQueue = intQueue.enqueue(3);
            intQueue = intQueue.enqueue(4);
            intQueue = intQueue.enqueue(5);

            while(!intQueue.isEmpty())
            {
                System.out.println(intQueue.head());
                intQueue = intQueue.dequeue();
            }
            System.out.println("Queue is empty, goodbye! :)");
        } catch (NoSuchElementException e) {
            System.out.println(":( Looks like you hit an empty queue!");
        }
    }
}
