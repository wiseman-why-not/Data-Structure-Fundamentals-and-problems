package recursion;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = fib(13);
		System.out.println(result);
	}
	
	public static Integer fib(int num) {
		if (num < 1 ) {
			System.out.println("number is lower than one.");
			return null;
		} else if (num == 1 || num == 2) {
			return num - 1;
		} else {
			return (fib(num - 1) + fib(num -2) );
		}
		
		
	}

}
