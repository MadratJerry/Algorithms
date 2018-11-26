# 2.2 [Mergesort](https://algs4.cs.princeton.edu/22mergesort/)

## Creative Problems

_2.2.10_ **Faster merge.** Implement a version of merge() that copies the second half of a[] to aux[] in decreasing order and then does the merge back to a[]. This change allows you to remove the code to test that each of the halves has been exhausted from the inner loop. Note: the resulting sort is not stable. 

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

_2.2.11_ **Improvements.** Write a program MergeX.java that implements the three improvements to mergesort that are described in the text: add a cutoff from small subarrays, test whether the array is already in order, and avoid the copy by switching arguments in the recursive code. 

Solution: [MergeX.java](MergeX.java)

_2.2.19_ **Inversions.** Develop and implement a linearithmic algorithm [Inversions.java](https://algs4.cs.princeton.edu/22mergesort/Inversions.java.html) for computing the number of inversions in a given array (the number of exchanges that would be performed by insertion sort for that array—see Section 2.1). This quantity is related to the Kendall tau distance; see Section 2.5. 

Solution: [Inversions.java](Inversions.java)
