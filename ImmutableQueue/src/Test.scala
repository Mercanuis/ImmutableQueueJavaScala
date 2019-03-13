import Queue.ImmutableQueue
import Stack.EmptyStack

object Test extends App {
   var queue = new ImmutableQueue[Int](new EmptyStack[Int], new EmptyStack[Int])
   queue.enqueue()
}
