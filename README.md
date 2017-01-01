# Java-Fibonacci-term-in-sequence
The following java file contains a method that allows to calculate a desired term in in the fibonacci sequence, in log n time complexity

  The following program includes a Final method to calculate a given term of the 
fibonacci's sequence. 
This method uses the fact that the relation of the fibonacci numbers
(<b>Fn = Fn-1 + Fn-2</b>) can be expressed as two dimensional system of equations in matrix form. 
This matrix representation gives the follwoing closed expresion for the fibonacci numbers:
<b>
<br>|1  1|^n       |Fn+1  Fn|
<br>|1  0|   =     |Fn    Fn-1|<br></b>
This identity allows the calculation of any fibonacci number by exponentiating the matrix 
to the needed power. 
This implementation alone would not be more effective, than the regular linear solution 
which is inherently fast(<b>O(n)</b>). 
The proposed solution for calculating a given term in the fibonacci sequence uses the exponentiation
of the fibonaccy matrix to its advantage by using exponentiation by squaring, an 
algorithm  allows the fast computation of large positive integer powers by reducing the number 
of multiplications needed to achieve the final solution.
The algorithm can be easily described by the following piecewise function:
<p>
<b>(x)(x^2)^((n-1)/2) if n is odd.<br>

<br>(x)^(2)^(n/2)  	if n is even.</b>
</p>
This allows the rapid exponentiation of the fibonacci matrix, reducing and setting the number of 
needed multiplications logarithmically. A brief analysis shows that the time complexity 
of the algorithm that implements exponentiation by squaring to be O(log(n)).
Included in this program is also a linear implementation to be used as reference and comparison to the 
solution.

