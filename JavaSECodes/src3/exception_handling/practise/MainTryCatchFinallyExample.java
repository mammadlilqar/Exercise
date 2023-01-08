package exception_handling.practise;

public class MainTryCatchFinallyExample {
public static void main(String[] args) {
	int a=5;
	int b=1;
	int[] m= {4,8};
	try {
		
		int c=a/b;
		System.out.println(m[1]);
		System.out.println(c);
	} catch (RuntimeException e) {
		System.out.println(e.getMessage());
	}finally {
		System.out.println("finally");
	}
	System.out.println("main end");
}
}
