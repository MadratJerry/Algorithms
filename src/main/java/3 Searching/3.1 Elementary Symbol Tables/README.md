# 3.1 [Elementary Symbol Tables](https://algs4.cs.princeton.edu/31elementary)

## Exercises

_3.1.2_ Develop a symbol-table implementation [ArrayST.java](https://algs4.cs.princeton.edu/31elementary/ArrayST.java.html) that uses an (unordered) array as the underlying data structure to implement our basic symbol table API.

Solution: [ArrayST.java](ArrayST.java)

_3.1.5_ Implement `size()`, `delete()`, and `keys()` for [SequentialSearchST.java](https://algs4.cs.princeton.edu/31elementary/SequentialSearchST.java.html). 

Solution: [SequentialSearchST.java](SequentialSearchST.java)

_3.1.16_ Implement the `delete()` method for [BinarySearchST.java](https://algs4.cs.princeton.edu/31elementary/BinarySearchST.java.html). 

Solution: [BinarySearchST.java](BinarySearchST.java)

_3.1.17_ Implement the `floor()` method for [BinarySearchST.java](https://algs4.cs.princeton.edu/31elementary/BinarySearchST.java.html). 

Solution: [BinarySearchST.java](BinarySearchST.java)

## Creative Problems

_3.1.29_ **Test client.** Write a test client [TestBinarySearchST.java](https://algs4.cs.princeton.edu/31elementary/TestBinarySearchST.java.html) for use in testing the implementations of `min()`, `max()`, `floor()`, `ceiling()`, `select()`, `rank()`, `deleteMin()`, `deleteMax()`, and `keys()`. 

Solution: [BinarySearchSTTest.java](../../../../test/java/3%20Searching/3.1%20Elementary%20Symbol%20Tables/BinarySearchSTTest.java)

_3.1.30_ **Certification.** Add `assert` statements to [BinarySearchST.java](https://algs4.cs.princeton.edu/31elementary/BinarySearchST.java.html) to check algorithm invariants and data structure integrity after every insertion and deletion. For example, every index `i` should always be equal to `rank(select(i))` and the array should always be in order. 

Solution: [BinarySearchST.java](BinarySearchST.java)
