package Queue

trait Queue[T] {

  /**
    * @return if the queue is empty
    */
  def isEmpty: Boolean

  /**
    * @param t Raw Type T to be added to queue
    * @return the Queue with the element T added
    */
  def enqueue(t: T) : Queue[T]

  /**
    * @return the Queue with the first element removed
    */
  def dequeue(): Queue[T]

  /**
    * @return the Element T at the head of the Queue
    */
  def head: Option[T]
}
