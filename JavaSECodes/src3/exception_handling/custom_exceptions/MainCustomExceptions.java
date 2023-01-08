package exception_handling.custom_exceptions;

public class MainCustomExceptions {
public static void main(String[] args) {
	System.out.println("Main begin");
	MyArrays w=new MyArrays();
	int s=0;
	try {
		s=w.getArrayValueByIndex(14);
	} catch (ArrayIndexOutOfBoundsException e) {
	System.out.println(e.getMessage());
	}
	
	System.out.println(s);
	System.out.println("Main end");
}
}
