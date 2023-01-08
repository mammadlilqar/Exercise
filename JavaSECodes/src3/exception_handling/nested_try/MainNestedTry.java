package exception_handling.nested_try;

public class MainNestedTry {
public static void main(String[] args) {
	try {
		try {
			int a=4/1;
			System.out.println(a);

		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} 
		
		int[] w= {4,8};
		System.out.println(w[1]);
		} catch (Exception e) {
		System.out.println(e.getMessage());
	}finally {
		System.out.println("main try finally");
	}
}
}
