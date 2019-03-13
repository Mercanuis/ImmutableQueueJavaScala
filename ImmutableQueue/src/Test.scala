import Queue.ImmutableQueue
import Stack.EmptyStack
import Queue.EmptyQueue

object Test extends App {
   var queue = new EmptyQueue[Int]
   queue.enqueue(1)
   queue.enqueue(2)
   queue.enqueue(3)
   queue.enqueue(4)
   queue.enqueue(5)

   while(!queue.isEmpty) {
      System.out.println(queue.head)
      queue = queue.dequeue()
   }
}
