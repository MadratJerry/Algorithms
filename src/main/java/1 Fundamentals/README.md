# 1 [Fundamentals](https://algs4.cs.princeton.edu/10fundamentals/)

## Overview

The objective of this book is to study a broad variety of important and useful algorithms—methods for solving problems that are suited for computer implementations. Algorithms go hand in hand with data structures—schemes for organizing data. This chapter introduces the basic tools that we need to study algorithms and data structures. 

- 1.1 [Basic Programming Model](1.1%20Basic%20Programming%20Model) introduces our basic programming model. All of our programs are implemented using a small subset of the Java programming language plus a few of our own libraries for input and output.
- 1.2 [Data Abstraction](1.2%20Data%20Abstraction) emphasizes data abstraction, where we define abstract data types (ADTs). We specify an applications programming interface (API) and then use the Java class mechanism to develop an implementation for use in client code.
- 1.3 [Bags, Queues, and Stacks](1.3%20Bags,%20Queues,%20and%20Stacks) considers three fundamental ADTs: the bag, the queue, and the stack. We describe APIs and implementations using resizing arrays and linked lists.
- 1.4 [Analysis of Algorithms](1.4%20Analysis%20of%20Algorithms) describes our approach to analyzing algorithm performance. The basis of our approach is the scientific method: we develop hypotheses about performance, create mathematical models, and run experiments to test them.
- 1.5 [Case Study: Union-Find](1.5%20Union-Find) is a case study where we consider solutions to a connectivity problem that uses algorithms and data structures that implement the classic union-find ADT. 

## Programs

|Status|Program|Description|
|:----:|:-----:|:---------:|
|✅|[BinarySearch.java](1.1%20Basic%20Programming%20Model/BinarySearch.java)|binary search|
|✅|[RandomSeq.java](1.1%20Basic%20Programming%20Model/RandomSeq.java)|random numbers in a given range|
|✅|[Average.java](1.1%20Basic%20Programming%20Model/Average.java)|average of a sequence of numbers|
|➖|Cat.java|concatenate files|
|➖|Knuth.java|Knuth shuffle|
|➖|Counter.java|counter|
|➖|StaticSETofInts.java|set of integers|
|➖|Whitelist.java|whitelist client|
|➖|Vector.java|Euclidean vector|
|➖|Date.java|date|
|➖|Transaction.java|transaction|
|➖|Point2D.java|point|
|➖|RectHV.java|axis-aligned rectangle|
|➖|Interval1D.java|1d interval|
|➖|Interval2D.java|2d interval|
|➖|Accumulator.java|running average and stddev|
|✅|[ResizingArrayStack.java](1.3%20Bags,%20Queues,%20and%20Stacks/ResizingArrayStack.java)|LIFO stack (resizing array)|
|✅|[LinkedStack.java](1.3%20Bags,%20Queues,%20and%20Stacks/LinkedStack.java)|LIFO stack (linked list)|
|✅|[Stack.java](1.3%20Bags,%20Queues,%20and%20Stacks/Stack.java)|LIFO stack|
|✅|[ResizingArrayQueue.java](1.3%20Bags,%20Queues,%20and%20Stacks/ResizingArrayQueue.java)|FIFO queue (resizing array)|
|✅|[LinkedQueue.java](1.3%20Bags,%20Queues,%20and%20Stacks/LinkedQueue.java)|FIFO queue (linked list)|
|✅|[Queue.java](1.3%20Bags,%20Queues,%20and%20Stacks/Queue.java)|FIFO queue|
|✅|[ResizingArrayBag.java](1.3%20Bags,%20Queues,%20and%20Stacks/ResizingArrayQueue.java)|multiset (resizing array)|
|✅|[LinkedBag.java](1.3%20Bags,%20Queues,%20and%20Stacks/LinkedBag.java)|multiset (linked list)|
|✅|[Bag.java](1.3%20Bags,%20Queues,%20and%20Stacks/Bag.java)|multiset|
|➖|Stopwatch.java|timer (wall time)|
|➖|StopwatchCPU.java|timer (CPU time)|
|➖|LinearRegression.java|simple linear regression|
|✅|[ThreeSum.java](1.4%20Analysis%20of%20Algorithms/ThreeSum.java)|brute-force three sum|
|✅|[ThreeSumFast.java](1.4%20Analysis%20of%20Algorithms/ThreeSumFast.java)|faster three sum|
|➖|DoublingTest.java|doubling test|
|➖|DoublingRatio.java|doubling ratio|
|➖|QuickFindUF.java|quick find|
|➖|QuickUnionUF.java|quick union|
|➖|WeightedQuickUnionUF.java|weighted quick union|
|➖|UF.java|union-by-rank with path halving|
