package Test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		//3. İstənilən bir tam ədədin daxilində istifadə edilmiş ən böyük rəqəmi tapan proqram yaz.
		
		
		Scanner sc = new Scanner(System.in);
	int number=sc.nextInt(),a,b,c,h,y,d,e;
	if(number>=100 && number<1000) {
		a=number/100;
		c=number%10;
		h=number-c;
		y=h%100;
		b=y/10;
		if(a>b && a>c) {
			System.out.println("en boyuk "+a);
		}
		else if(b>a && b>c) {
			System.out.println("en boyuk "+b);
		}
		else if(c>a && c>b) {
			System.out.println("boyuk "+c);
		}
		else {
			System.out.println("reqemleri muxtelif eded daxil edin!");
		}
	}
	else if(number<100 && number>=10) {
		d=number%10;
		e=number/10;
		if(d>e) {
			System.out.println("en boyuk "+d);
		}
		else if(d<e) {
			System.out.println("en boyuk "+e);
		}
		else {
			System.out.println("duzgun eded daxil edin!");
			
		}
		
	}
	
			
		

			
			

		
	}

}
