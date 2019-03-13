# ImmutableQueueJava
An attempt to implement an 'immutable' queue in Java

ImmutableQueue attempts to create an immutable queue per functional programming paradigms When something new is added to the queue, rather than modify the existing queue a new queue will be made. Conversely, when something is removed from the queue, rather than modify the existing queue a new queue will be made.

The class attempts to run an efficiency loop per this article - **[immutable queues in C#](https://blogs.msdn.microsoft.com/ericlippert/2007/12/10/immutability-in-c-part-four-an-immutable-queue/)** - 
that attempts to optimize de-queueing from the queue by keeping a reverse stack that has the correct reverse order of the queue for faster de-queueing
