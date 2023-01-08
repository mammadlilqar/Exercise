package exception_handling.custom_exceptions;

public class MyArrays {
private int[] array= {3,6,2,45,787};
public int getArrayValueByIndex(int index) {
	int result=0;
	if(index>=array.length) {
		throw new MassivException("massivin olmayan elementine muraciet etmek olmaz!");
	}
	if(index<0) {
		System.out.println("massivde  menfi indeks yoxdur");
	}
	result=array[index];
	return result;
}
}
