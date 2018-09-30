# 1.2 [Data Abstraction](https://algs4.cs.princeton.edu/12oop/)

## Exercises

_1.2.6_ A string s is a circular rotation of a string t if it matches when the characters are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of TGACGAC, and vice versa. Detecting this condition is important in the study of genomic sequences. Write a program that checks whether two given strings s and t are circular shifts of one another.

Solution:

```
(s.length() == t.length()) && (s.concat(s).indexOf(t) >= 0)
```

_1.2.7_ What does the following recursive function return?

```
public static String mystery(String s) {
    int N = s.length();
    if (N <= 1) return s;
    String a = s.substring(0, N/2);
    String b = s.substring(N/2, N);
    return mystery(b) + mystery(a);
}
```

Solution: Reverse of the string.
