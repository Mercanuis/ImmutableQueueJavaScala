package Stack;

import java.util.NoSuchElementException;

/**
 * ImmutableStack attempts to create an immutable stack per functional programming paradigms
 * When something new is added to the stack, rather than modify the existing stack a new stack will be made.
 * Conversely, when something is removed from the stack, rather than modify the existing stack a new stack
 * will be made.
 *
 * This class is used as an underlying structure for the {@link Queue.ImmutableQueue} class
 *
 * @param <T> Generic Raw Type to initialize and be used to work with the stack.
 */
public class ImmutableStack<T> implements IStack<T>
{
    private static final class EmptyStack<T> implements IStack<T>
    {
        private static final EmptyStack emptyStack = new EmptyStack();

        private static EmptyStack getInstance()
        {
            return emptyStack;
        }

        @Override
        public final IStack<T> push(T t)
        {
            return new ImmutableStack<T>(t, this);
        }

        @Override
        public final IStack<T> pop()
        {
            throw new NoSuchElementException();
        }

        @Override
        public final T head()
        {
            throw new NoSuchElementException();
        }

        @Override
        public final boolean isEmpty()
        {
            return true;
        }
    }

    public static IStack getEmptyStack()
    {
        return EmptyStack.getInstance();
    }

    private final T head;
    private final IStack<T> tail;

    private ImmutableStack(T head, IStack<T> tail)
    {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public final IStack<T> push(T t)
    {
        return new ImmutableStack<T>(t, this);
    }

    @Override
    public final IStack<T> pop()
    {
        return tail;
    }

    @Override
    public final T head()
    {
        return head;
    }

    @Override
    public final boolean isEmpty()
    {
        return false;
    }
}
