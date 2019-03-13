package Stack

trait Stack[T] {

  /**
    * @param t Raw Type T to be added to stack
    * @return the Stack with the element T added
    */
  def push(t: T): Stack[T]

  /**
    * @return the Stack with the top element removed
    */
  def pop(): Stack[T]

  /**
    * @return the element at the top of the Stack
    */
  def head: T

  /**
    * @return if the Stack is empty
    */
  def isEmpty: Boolean
}
