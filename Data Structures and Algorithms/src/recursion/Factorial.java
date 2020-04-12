package recursion;

public class Factorial {

	public static void main(String[] args) {
		int result = factorial(5);
		System.out.println(result);

	}
	
	public static int factorial(int num) {
		if (num == 0) {
			return 1;
		}
		return (num * factorial(num - 1) );
	}

}
