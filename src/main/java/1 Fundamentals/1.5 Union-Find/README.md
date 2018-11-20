# 1.5 Case Study: Union-Find

## Exercises

_1.5.7_ Develop classes [QuickUnionUF.java](https://algs4.cs.princeton.edu/15uf/QuickUnionUF.java.html) and [QuickFindUF.java](https://algs4.cs.princeton.edu/15uf/QuickFindUF.java.html) that implement quick-union and quick-find, respectively. 

Solution: [QuickUnionUF.java](QuickUnionUF.java) [QuickFindUF.java](QuickFindUF.java)
 
## Creative Problems

_1.5.12_ **Quick-union with path compression.** Modify [QuickUnionUF.java](https://algs4.cs.princeton.edu/15uf/QuickUnionUF.java.html) to include path compression, by adding a loop to `find()` that links every sie on the path from p to the root. Give a sequence of input pairs that causes this method to produce a path of length 4. Note: the amortized cost per operation for this algorithm is known to be logarithmic. 

Solution: [QuickUnionPathCompressionUF.java](QuickUnionPathCompressionUF.java)
