package Queue

import Stack.Stack
import Stack.EmptyStack
import Queue.EmptyQueue

class ImmutableQueue[T](f: Stack[T], b: Stack[T]) extends Queue[T] {

  class EmptyQueue[T] extends Queue[T] {
    private final var emptyQueue = EmptyQueue.this
    private [this] def getInstance = emptyQueue

    /**
      * @return if the queue is empty
      */
    override def isEmpty: Boolean = true

    /**
      * @param t Raw Type T to be added to queue
      * @return the Queue.Queue with the element T added
      */
    override def enqueue(t: T): Queue[T] = new ImmutableQueue[T](new EmptyStack[T].push(t), new EmptyStack[T])

    /**
      * @return the Queue.Queue with the first element removed
      */
    override def dequeue(): Queue[T] = throw new NoSuchElementException

    /**
      * @return the Element T at the head of the Queue.Queue
      */
    override def head: Option[T] = throw new NoSuchElementException
  }

  /**
    * @return if the queue is empty
    */
  override def isEmpty: Boolean = false

  /**
    * @param t Raw Type T to be added to queue
    * @return the Queue.Queue with the element T added
    */
  override def enqueue(t: T): Queue[T] = new ImmutableQueue[T](f, b.push(t))

  /**
    * @return the Queue.Queue with the first element removed
    */
  override def dequeue(): Queue[T] = {
    var s = f.pop()
    if(!s.isEmpty) {
       new ImmutableQueue[T](s, b)
    } else if (b.isEmpty) {
       new ImmutableQueue[T](new EmptyStack[T], new EmptyStack[T])
    } else {
       new ImmutableQueue[T](reverse(b), new EmptyStack[T])
    }
  }

  /**
    * @return the Element T at the head of the Queue.Queue
    */
  override def head: Option[T] = Option[T](f.head)

  private def reverse(stack: Stack[T]): Stack[T] = {
    var s = stack
    var reversed = new EmptyStack[T]
    while(!s.isEmpty) {
      reversed = reversed.push(stack.head)
      s = s.pop()
    }
    return reversed
  }
}
