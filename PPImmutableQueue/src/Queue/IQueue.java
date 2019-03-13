package Queue;

public interface IQueue<T>
{
    /**
     * Enqueues the element into the Queue.IQueue
     * @param t the T type to be inserted into the queue
     * @return Queue.IQueue with the new element
     */
    IQueue<T> enqueue(T t);

    /**
     * Dequeues the element at the end of the head of the queue
     * @return Queue.IQueue minus the de-queued element
     */
    IQueue<T> dequeue();


    /**
     * @return the element T at the head of the queue
     */
    T head();

    /**
     * @return boolean reflecting if the queue is empty or not
     */
    boolean isEmpty();
}
