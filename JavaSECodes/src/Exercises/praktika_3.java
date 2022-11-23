package Exercises;

public class praktika_3 {
	public static void main(String[] args) {
		//1. 50-dən 20-yə kimi ədədləri azalan sıra ilə konsola çap edən proqram yaz
		for(int a=50;a>=20;a--) {
			System.out.println(a);
		}
		//2. 0-dan 5-ə kimi ədədləri, 0.1 aralıqla artmaq şərti ilə konsola çap et.
		for(double b=0;b<=5;b=b+0.1) {
			System.out.println(b);
		}
		
		//3. İstənilən bir tam ədədin daxilində istifadə edilmiş ən böyük rəqəmi tapan proqram yaz.
		int a=334,c,f;
		c=a%10;
		f=(a-c)%100;
		
	}

}
