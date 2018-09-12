# 1.2 [Data Abstraction](https://algs4.cs.princeton.edu/12oop/)

## Exercises

*1.2.1* Write a [Point2D.java](https://algs4.cs.princeton.edu/12oop/Point2D.java.html) client that takes an integer value N from the command line, generates N random points in the unit square, and computes the distance separating the closest pair of points. 

*1.2.4* What does the following code fragment print? 

```
String string1 = "hello";
String string2 = string1;
string1 = "world";
StdOut.println(string1);
StdOut.println(string2);
```

Solution: 
```
world
hello
```
 
*1.2.6* A string s is a circular rotation of a string t if it matches when the characters are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of TGACGAC, and vice versa. Detecting this condition is important in the study of genomic sequences. Write a program that checks whether two given strings s and t are circular shifts of one another. 

Solution: 
```
(s.length() == t.length()) && (s.concat(s).indexOf(t) >= 0)
```

*1.2.7* What does the following recursive function return?
    
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

*1.2.13* Using our implementation of [Date.java](https://algs4.cs.princeton.edu/12oop/Date.java.html) as a model, develop an implementation of [Transaction.java](https://algs4.cs.princeton.edu/12oop/Transaction.java.html). 

*1.2.14* Using our implementation of `equals()` in [Date.java](https://algs4.cs.princeton.edu/12oop/Date.java.html) as a model, develop an implementation of equals() for [Transaction.java](https://algs4.cs.princeton.edu/12oop/Transaction.java.html). 

## Creative Problems

*1.2.16* **Rational numbers.** Implement an immutable data type [Rational.java](https://algs4.cs.princeton.edu/12oop/Rational.java.html) for rational numbers that supports addition, subtraction, multiplication, and division. 

![api for rational numbers](https://algs4.cs.princeton.edu/12oop/images/rational-api.png)

You do not have to worry about testing for overflow, but use as instance variables two long values that represent the numerator and denominator to limit the possibility of overflow. Use Euclid's algorithm to ensure that the numerator and denominator never have any common factors. Include a test client that exercises all of your methods.

*1.2.18* **Sample variance for accumulator.** Validate that the following code, which adds the methods `var()` and `stddev()` to [Accumulator.java](https://algs4.cs.princeton.edu/12oop/Accumulator.java.html) to compute the mean, sample variance, and sample standard deviation of the numbers presented as arguments to addDataValue().

Reference: Here is a good [explanation](http://www.johndcook.com/standard_deviation.html) of this one-pass method, that was first discovered by Welford in 1962. This approach can be applied to computing the skewness, kurtosis, regression coefficients, and Pearson's correlation coefficient. 

*1.2.19* **Parsing.** Develop the parse constructors for your Date.java and Transaction.java implementations that take a single String argument to specify the initialization values, using the formats given in the table below.

![parsing for Date and Transaction](https://algs4.cs.princeton.edu/12oop/images/parsing.png)
