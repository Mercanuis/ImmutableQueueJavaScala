package Queue

import Stack.EmptyStack

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

  def getEmptyQueue: Queue[T] = getInstance
}
