package exception_handling.throw_keyword;

public class MainThrowKeyword{
public static void main(String[] args) {
	int[] arr= {12,34,21,65};
  int a=0;
	try {
		 a=getValue(arr,2);
} catch (ArrayIndexOutOfBoundsException e) {
System.out.println(e.getMessage());
}
	System.out.println(a);
	
}
public static int getValue(int[] array,int index) {
	if(index>=array.length) {
		throw new ArrayIndexOutOfBoundsException("Massivin olmayan elementine muraciet etmek olmaz!");
		}
	if(index<0) {
		throw new ArrayIndexOutOfBoundsException("Massivin menfi indeksi yoxdur");
	}
	return array[index];
}
}
  