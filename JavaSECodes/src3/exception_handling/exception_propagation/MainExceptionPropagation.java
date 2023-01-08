package exception_handling.exception_propagation;

public class MainExceptionPropagation {
public static void main(String[] args) {
	System.out.println("main begin");
	m1();
	System.out.println("main end");
}
static void m1() {
	m2();
}
static void m2() {
	
	try {
		m3();
	} catch (Exception e) {
	e.printStackTrace();
	}
}
static void m3() {
	
	int a=3/0;
}
}
