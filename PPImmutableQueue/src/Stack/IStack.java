package Stack;

public interface IStack<T>
{
    /**
     * @param t the element of type T
     * @return stack with the new element
     */
    IStack<T> push(T t);

    /**
     * @return stack with the top element removed
     */
    IStack<T> pop();

    /**
     * @return the element T at the head of the queue
     */
    T head();

    /**
     * @return boolean reflecting if the queue is empty or not
     */
    boolean isEmpty();
}
