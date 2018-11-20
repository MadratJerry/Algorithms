# 1.5 Case Study: Union-Find

## Exercises

_1.5.7_ Develop classes [QuickUnionUF.java](https://algs4.cs.princeton.edu/15uf/QuickUnionUF.java.html) and [QuickFindUF.java](https://algs4.cs.princeton.edu/15uf/QuickFindUF.java.html) that implement quick-union and quick-find, respectively. 

Solution: [QuickUnionUF.java](QuickUnionUF.java) [QuickFindUF.java](QuickFindUF.java)
 
## Creative Problems

_1.5.12_ **Quick-union with path compression.** Modify [QuickUnionUF.java](https://algs4.cs.princeton.edu/15uf/QuickUnionUF.java.html) to include path compression, by adding a loop to `find()` that links every sie on the path from p to the root. Give a sequence of input pairs that causes this method to produce a path of length 4. 

Note: the amortized cost per operation for this algorithm is known to be logarithmic. 

Solution: [QuickUnionPathCompressionUF.java](QuickUnionPathCompressionUF.java)

_1.5.13_ **Weighted quick-union with path compression.** Modify [WeightedQuickUnionUF.java](https://algs4.cs.princeton.edu/15uf/WeightedQuickUnionUF.java.html) to implement path compression, as described in Exercise 1.5.12. Give a sequence of input pairs that causes this method to produce a tree of height 4.

Note: The amortized cost per operation for this algorithm is known to be bounded by a function known as the inverse Ackermann function and is less than 5 for any conceivable value of N that arises in practice. 

Solution: [WeightedQuickUnionPathCompressionUF.java](WeightedQuickUnionPathCompressionUF.java)

_1.5.14_ **Weighted quick-union by height.** Develop a implementation [WeightedQuickUnionByHeightUF.java](https://algs4.cs.princeton.edu/15uf/WeightedQuickUnionByHeightUF.java.html) that uses the same basic strategy as weighted quick-union but keeps track of tree height and always links the shorter tree to the taller one. Prove a logarithmic upper bound on the height of the trees for N sites with your algorithm.

Solution: [WeightedQuickUnionByHeightUF.java](WeightedQuickUnionByHeightUF.java)
