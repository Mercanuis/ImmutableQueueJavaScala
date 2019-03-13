package Stack

class ImmutableStack[T](h: T, t: Stack[T]) extends Stack[T] {

  /**
    * @param t Raw Type T to be added to stack
    * @return the Stack.Stack with the element T added
    */
  override def push(t: T): Stack[T] = new ImmutableStack[T](t, this)

  /**
    * @return the Stack.Stack with the top element removed
    */
  override def pop(): Stack[T] = t

  /**
    * @return the element at the top of the Stack.Stack
    */
  override def head: T = h

  /**
    * @return if the Stack.Stack is empty
    */
  override def isEmpty: Boolean = false
}
