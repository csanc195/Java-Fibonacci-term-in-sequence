
/*************************************************************************************************** 
	Purpose/Description: 
	The following program includes a Final method to calculate a given term of the 
fibonacci's sequence. 
	This method uses the fact that the relation of the fibonacci numbers
Fn = Fn-1 + Fn-2 can be expressed as two dimensional system of equations in matrix form. 
This matrix representation gives the follwoing closed expresion for the fibonacci numbers:

|1 1|^n   |Fn+1 Fn  |
|1 0|   = |Fn   Fn-1| 
This identity allows the calculation of any fibonacci number by exponentiating the matrix 
to the needed power. 
	This implementation alone would not be more effective, than the regular linear solution 
which is inherently fast(O(n)). 
The proposed solution for calculating a given term in the fibonacci sequence uses the exponentiation
of the fibonaccy matrix to its advantage by using exponentiation by squaring, an 
algorithm  allows the fast computation of large positive integer powers by reducing the number 
of multiplications needed to achieve the final solution.
The algorithm can be easily described by the following piecewise function:

	|(x)(x^2)^((n-1)/2) if n is odd.
x^n =	|
	|(x)^(2)^(n/2)  	if n is even.
This allows the rapid exponentiation of the fibonacci matrix, reducing and setting the number of 
needed multiplications logarithmically. A brief analysis shows that the time complexity 
of the algorithm that implements exponentiation by squaring to be O(log(n)).
Included in this program is also a linear implementation to be used as reference and comparison to the 
solution.
 **************************************************************************************************/



/**
 * This is a final class with no attributes, just a public method 
 * calculateFibonacci() and a group of private methods used to 
 * assist said method in computing the answer.
 */
import java.math.BigInteger;
public final class Problem2 {

	/**
	 * This method calculates a solicited fibonacci number
	 * @param n This is the only parameter, which indicates the term to
	 * be calculated.
	 * @return BigInteger This returns the computed fibonacci number.
	 */
	public static final BigInteger calculateFibonacci(long n){
		if (n < 0){
			return new BigInteger("0"); // Might as well raise an exception, for simplicity will return just "0";
		}
		BigInteger [][] matrixA = {{BigInteger.ONE, BigInteger.ONE},{BigInteger.ONE, BigInteger.ZERO}};
		return matrixPow(matrixA, n)[1][1];
	}

	/**
	 * This method implements exponentiation by squaring
	 * @param matrixA matrix to be multiplied
	 * @param exponent is the exponent that indicates the targeted fibonacci
	 * @return BigInteger[][] This returns the result of the exponentiation of (matrixA)^exponent.
	 */
	private static BigInteger [][] matrixPow(BigInteger [][]matrixA, long exponent){
		BigInteger [][] matrixB = {{BigInteger.ONE, BigInteger.ONE},{BigInteger.ONE, BigInteger.ZERO}};

		while(exponent!=0){
			if(exponent % 2 != 0)
				matrixB = multiplyMatrices(matrixB, matrixA);
			exponent /= 2;
			matrixA = multiplyMatrices(matrixA, matrixA);
		}
		return matrixB;
	}

	/**
	 * This method implements a simple matrix multiplication algorithm that multiplies two
	 * 2x2 matrices and returns the resulting 2x2 matrix.
	 * @param matrixA  First matrix to be multiplied
	 * @param matrixB  Second matrix to be multiplied
	 * @return BigInteger[][] This returns the result of the multiplication of matrixA and matrixB.
	 */
	private static BigInteger [][] multiplyMatrices(BigInteger[][] matrixA, BigInteger [][] matrixB){

		BigInteger a = (matrixA[0][0].multiply(matrixB[0][0])).add(matrixA[0][1].multiply(matrixB[1][0]));
		BigInteger b = (matrixA[0][0].multiply(matrixB[0][1]).add(matrixA[0][1].multiply(matrixB[1][1])));
		BigInteger c = (matrixA[1][0].multiply(matrixB[0][0])).add(matrixA[1][1].multiply(matrixB[1][0]));
		BigInteger d = (matrixA[1][0].multiply(matrixB[0][1])).add(matrixA[1][1].multiply(matrixB[1][1]));

		return new BigInteger [][]{{a,b},{c,d}};
	}

	/**
	 * This method calculates a given fibonacci in linear time. O(n).
	 * Used as reference and as comparison to test and implement the main 
	 * method for this class "calculateFibonacci()"
	 * @param target this is the fibonacci to be calculated.
	 * @return returns the String representation of the fibonacci number.
	 */
	public static final String calculateFibonacciLinear(long target){

		BigInteger fib1 =new BigInteger("1");
		BigInteger fib2 = new BigInteger("1");
		BigInteger temp1 =new BigInteger("0");

		if(target == 0){
			return "0";
		}
		else if(target <=2){
			return "1";
		}else{
			int count =0;
			while(count <target-2){
				temp1 = fib1;
				fib1 = fib2;
				fib2=fib2.add(temp1);
				count++;
			}
		}
		return fib2.toString();
	}

	// Simple toString method used for testing.
	public static final void toString(BigInteger [][] matrix){
		String a ="";
		for(int i=0; i<2; i++){
			for(int j=0; j<2; j++){
				a+= " " + matrix[i][j];
			}
			a+= "\n";
		}
		System.out.println(a);
	}

}
