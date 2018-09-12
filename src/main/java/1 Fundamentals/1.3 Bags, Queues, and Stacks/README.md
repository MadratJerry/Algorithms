# 1.3 [Bags, Queues, and Stacks](https://algs4.cs.princeton.edu/13stacks/)

## Practice Quiz

1. **Queue with two stacks.** Implement a queue with two stacks so that each queue operations takes a constant amortized number of stack operations.

   Note: these interview questions are ungraded and purely for your own enrichment. To get a hint, submit a solution.

   > Hint: If you push elements onto a stack and then pop them all, they appear in reverse order. If you repeat this process, they're now back in order.

   Enqueue is to push element to _stack A_ and dequeue is to pop element from _stack B_, if `stack A` is empty, just pop all elements from _stack A_ and push them into _stack B_.

   Now, enqueue is only one operation, dequeue is at most `2n` operation, `n` is the number of elements, so the amortized number of operations for dequeue is `2n / n = 2`.

2. **Stack with max.** Create a data structure that efficiently supports the stack operations (push and pop) and also a return-the-maximum operation. Assume the elements are reals numbers so that you can compare them.

   > Hint: Use two stacks, one to store all of the items and a second stack to store the maximums.

   A stack with an sorted array to maintain the order.

3. **Java generics.** Explain why Java prohibits generic array creation.

   > Hint: to start, you need to understand that Java arrays are covariant but Java generics are not: that is, `String[]` is a subtype of `Object[]`, but `Stack<String>` is not a subtype of `Stack<Object>`.

   It's due to type erasure. Java's Generics type parameter is the compile time information. It's erased in runtime, so a List<String> is erased to List. All the generic type of List share the common class List.class. While java's array is different, different type of array has its own class, for example , String[] and Integer[] have two different class. To determine an array's class type, we need the component type which is the type of the array element which is returned by Class.getComponentType method.

## Programming Assignment: Deques and Randomized Queues

- [specification](http://coursera.cs.princeton.edu/algs4/assignments/queues.html)
- [checklist](http://coursera.cs.princeton.edu/algs4/checklists/queues.html)
- [code](Assignment)
