# 2.2 [Mergesort](https://algs4.cs.princeton.edu/22mergesort/)

## Creative Problems

_10._ **Faster merge.** Implement a version of merge() that copies the second half of a[] to aux[] in decreasing order and then does the merge back to a[]. This change allows you to remove the code to test that each of the halves has been exhausted from the inner loop. Note: the resulting sort is not stable. 

Solution:

```
private static void merge(Comparable[] a, int lo, int mid, int hi) { 
   for (int i = lo; i <= mid; i++)
      aux[i] = a[i]; 
   
   for (int j = mid+1; j <= hi; j++)
      aux[j] = a[hi-j+mid+1];
  
   int i = lo, j = hi; 
   for (int k = lo; k <= hi; k++) 
      if (less(aux[j], aux[i])) a[k] = aux[j--];
      else                      a[k] = aux[i++];
} 
```

_11._ **Improvements.** Write a program MergeX.java that implements the three improvements to mergesort that are described in the text: add a cutoff from small subarrays, test whether the array is already in order, and avoid the copy by switching arguments in the recursive code. 

Solution: [MergeX.java](MergeX.java)

[//]: #
(TODO)
