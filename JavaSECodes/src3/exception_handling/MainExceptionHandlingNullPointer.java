package exception_handling;

public class MainExceptionHandlingNullPointer {
public static void main(String[] args) {
	System.out.println("Begin");
	String s=new String("Hello");
	System.out.println(s.charAt(33));
    System.out.println("End");
}
}
