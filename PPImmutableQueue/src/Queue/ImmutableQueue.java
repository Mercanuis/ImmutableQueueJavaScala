package Queue;

import java.util.NoSuchElementException;

import Stack.IStack;
import Stack.ImmutableStack;

/**
 * ImmutableQueue attempts to create an immutable queue per functional programming paradigms
 * When something new is added to the queue, rather than modify the existing queue a new queue will be made.
 * Conversely, when something is removed from the queue, rather than modify the existing queue a new queue
 * will be made.
 *
 * The class attempts to run an efficiency loop per this article
 * <b>https://blogs.msdn.microsoft.com/ericlippert/2007/12/10/immutability-in-c-part-four-an-immutable-queue/</b>
 * that attempts to optimize de-queueing from the queue by keeping a reverse stack that has the correct reverse
 * order of the queue for faster de-queueing
 *
 * @param <T> Generic Raw Type to initialize and be used to work with the Queue.
 */
public class ImmutableQueue<T> implements IQueue<T>
{
    private static class EmptyQueue<T> implements IQueue<T>
    {
        private static final EmptyQueue emptyQueue = new EmptyQueue();
        static EmptyQueue getInstance()
        {
            return emptyQueue;
        }

        @Override
        public IQueue<T> enqueue(T t)
        {
            return new ImmutableQueue<T>(ImmutableStack.getEmptyStack().push(t), ImmutableStack.getEmptyStack());
        }

        @Override
        public IQueue<T> dequeue()
        {
            throw new NoSuchElementException();
        }

        @Override
        public T head()
        {
            throw new NoSuchElementException();
        }

        @Override
        public boolean isEmpty()
        {
            return true;
        }
    }

    private IStack<T> forwards;
    private IStack<T> backwards;

    private ImmutableQueue(IStack<T> f, IStack<T> b)
    {
        forwards = f;
        backwards = b;
    }

    public static IQueue getNewQueue()
    {
        return EmptyQueue.getInstance();
    }

    @Override
    public IQueue<T> enqueue(T t)
    {
        return new ImmutableQueue<T>(forwards, backwards.push(t));
    }

    @Override
    public IQueue<T> dequeue()
    {
        IStack<T> stack = forwards.pop();
        if(!stack.isEmpty())
        {
            return new ImmutableQueue<T>(stack, backwards);
        }
        else if(backwards.isEmpty())
        {
            return ImmutableQueue.getNewQueue();
        }
        else
        {
            return new ImmutableQueue<T>(ImmutableQueue.reverse(backwards), ImmutableStack.getEmptyStack());
        }
    }

    @Override
    public T head()
    {
        return forwards.head();
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    private static IStack reverse(IStack stack)
    {
        IStack reversed = ImmutableStack.getEmptyStack();
        while(!stack.isEmpty())
        {
            reversed = reversed.push(stack.head());
            stack = stack.pop();
        }
        return reversed;
    }
}
