package Stack

class EmptyStack[T] extends Stack[T] {
  private final var emptyStack = EmptyStack.this
  private [this] def getInstance = emptyStack

  /**
    * @param t Raw Type T to be added to stack
    * @return the Stack.Stack with the element T added
    */
  override def push(t: T): Stack[T] = new ImmutableStack[T](t, this.emptyStack)

  /**
    * @return the Stack.Stack with the top element removed
    */
  override def pop(): Stack[T] = throw new NoSuchElementException

  /**
    * @return the element at the top of the Stack.Stack
    */
  override def head: T = throw new NoSuchElementException

  /**
    * @return if the Stack.Stack is empty
    */
  override def isEmpty: Boolean = true

  def getEmptyStack: Stack[T] = getInstance
}
