package exception_handling.multi_catch;

public class MainExceptionsMultiCatch {
public static void main(String[] args) {
	int a=5;
	int b=0;
	int[] m= {4,8};
	try {
		String s=null;
		s.charAt(3);
		int c=a/b;
		System.out.println(m[2]);
		System.out.println(c);
	} catch (ArithmeticException e) {
		System.out.println("ArithmeticException");
		System.out.println(e.getMessage());
	}catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("ArrayIndexOutOfBoundsException");
		System.out.println(e.getMessage());
	}catch(RuntimeException e) {
		System.out.println("RuntimeException");
		System.out.println(e.getMessage());
	}
	finally {
		System.out.println("finally");
	}
	System.out.println("main end");

}
}
