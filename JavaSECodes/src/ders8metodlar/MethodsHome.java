package ders8metodlar;

public class MethodsHome {
	public static void main(String[] args) {
		MethodsHome h=new MethodsHome();
		h.printNumbers(22,33);
	}
	void printNumbers(int begin,int end) {
		
		for(begin=begin;begin<=end;begin++){
			System.out.println(begin);
		}
	}

}
