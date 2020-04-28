package recursion;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double before = System.currentTimeMillis();
		int result = fib(14);
		double after = System.currentTimeMillis();
		System.out.println(result);
		System.out.println("time taken in milliseconds: " + (after - before));
		System.out.println("=========================");
		
		double before1 = System.currentTimeMillis();
		int result1 = fibDriver(14);
		double after1 = System.currentTimeMillis();
		System.out.println(result1);
		System.out.println("time taken in milliseconds: " + (after1 - before1));
	}
	
	public static Integer fib(int num) {
		if (num == 0 ) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else {
			return (fib(num - 1) + fib(num - 2) );
		}
		
	}
	
	// Fibonacci with memoization
	
	public static int fibDriver(int n) {
		int[] cache = new int[n +1];
		return fibWithCache(n, cache);
	}
	
	public static int fibWithCache(int n, int[] cache) {
		
		if (n == 0) {
			   return 0;
			  } else if (n == 1) {
			   return 1;
			  }

			  // Return cache value if it already exists
			  if (cache[n] != 0) {
			    return cache[n];
			  }

			  // Cache answer so later calls can use it
			  cache[n] = fibDriver(n - 1) + fibDriver(n - 2);

			  return cache[n];
	}

}
