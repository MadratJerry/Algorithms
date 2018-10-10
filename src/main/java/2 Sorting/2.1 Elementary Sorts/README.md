# 2.1 [Elementary Sorts](https://algs4.cs.princeton.edu/21elementary/)

## Creative Problems

_2.1.15_ **Expensive exchange.** A clerk at a shipping company is charged with the task of rearranging a number of large crates in order of the time they are to be shipped out. Thus, the cost of compares is very low (just look at the labels) relative to the cost of exchanges (move the crates). The warehouse is nearly full: there is extra space sufficient to hold any one of the crates, but not two. Which sorting method should the clerk use?

Solution: Use selection sort because it minimizes the number of exchanges.

_2.1.18_ **Visual trace.** Modify your solution to the previous exercise to make [Insertion.java](https://algs4.cs.princeton.edu/21elementary/Insertion.java.html) and [Selection.java](https://algs4.cs.princeton.edu/21elementary/Selection.java.html) produce visual traces such as those depicted in this section.

[//]: #
(TODO)

## Experiments

_2.1.24_ **Insertion sort with sentinel.** Develop an implementation [InsertionX.java](https://algs4.cs.princeton.edu/21elementary/InsertionX.java.html) of insertion sort that eliminates the j > 0 test in the inner loop by first putting the smallest item into position. Use [SortCompare.java](https://algs4.cs.princeton.edu/21elementary/SortCompare.java.html) to evaluate the effectiveness of doing so. Note: it is often possible to avoid an index-out-of-bounds test in this way—the item that enables the test to be eliminated is known as a sentinel. 

Solution: [InsertionX.java](InsertionX.java)

_2.1.25_ **Insertion sort without exchanges.** Develop an implementation [InsertionX.java](https://algs4.cs.princeton.edu/21elementary/InsertionX.java.html) of insertion sort that moves larger items to the right one position rather than doing full exchanges. Use [SortCompare.java](https://algs4.cs.princeton.edu/21elementary/SortCompare.java.html) to evaluate the effectiveness of doing so.

Solution: [InsertionX.java](InsertionX.java)

## Web Exercises

_1._ **Sorting networks.** Write a program [Sort3.java](https://algs4.cs.princeton.edu/21elementary/Sort3.java.html) with three if statements (and no loops) that reads in three integers a, b, and c from the command line and prints them out in ascending order. 

Solution: [Sort3.java](Sort3.java)

_3._ **Optimal oblivious sorting networks.** Create a program that sorts four integers using only 5 if statements, and one that sorts five integers using only 9 if statements of the type above? Oblivious sorting networks are useful for implementing sorting algorithms in hardware. How can you check that your program works for all inputs? 

Solution: [Sort4.java](Sort4.java) [Sort5.java](Sort5.java)

[//]: #
(TODO Web Exercises)
