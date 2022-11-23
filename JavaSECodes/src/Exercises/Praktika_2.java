package Exercises;

import java.util.Scanner;

public class Praktika_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1)1 və 5 aralığında olan tam ədədləri konsola çap edən proqram yaz
		for (int b = 1; b <= 5; b++) {
			System.out.println(b);
		}
		
		
		// 2)İki ədədi cəmləyən və nəticəsini konsola çıxardan proqram yaz.
		int f=66,s=32;
		
		System.out.println("Iki ededin cemi:" + (f + s));

		
		// 3)İki ədədi birbirinə vuran və nəticəsini konsola çıxardan proqram yaz.
		int a = sc.nextInt();
		int c = sc.nextInt();
		System.out.println("iki ededin hasili:" + (a * c));

		
		// 4)Çevrənin radiusuna görə onun uzunluğunu hesablayan proqram yaz.
		System.out.println("Çevrənin radiusunu daxil edin:");
		double r = sc.nextDouble(), l;
		l = 2 * Math.PI * r;
		System.out.println("Çevrənin uzunluğu:" + l);
         	
	   
		//5)Verilmiş istənilən ədədin rəqəmlərinin cəmini tapan proqram yaz.
		System.out.println("Iki eded daxil edin:");
		int d = sc.nextInt();
		int e = sc.nextInt();
		System.out.println("Iki ededin cemi:" + (d + e));
		
	
		//6)Verilmiş istənilən ədədin sadə olub-olmamasını tapan proqram yaz.
		
		int eded = 12, w;
		w = eded / 2;
		if (eded != 0 || eded != 1) {
			for (int i = 2; i <= w; i++) {
				if (eded % i == 0) {
					
				System.out.println("eded murekkebdir");
				break;
				}

			}

		} else {
			System.out.println("eded sadedir");

		}
			
			
			
			
	  //7)1-100 aralığında olan bütün tam ədədlərin cəmini tapan proqram yaz
			int cem=0;
			for(int q=1;q<=100;q++) {
				cem=cem+q;
			}	
			System.out.println("1-100 arasi ededlerin cemi:"+cem);
	
	
			
			//8)1-100 aralığında olan və 7-yə qalıqsız bölünən bütün tam ədədləri konsola çıxaran proqram yaz.
	for(int i=1;i<=100;i++) {
		if(i%7==0) {
			System.out.println("7-e qaliqsiz bolunen ededler:"+i);
		}
	}
	
	
	
	    //9)Verilmiş istənilən ədədin cüt olub-olmamasını yoxlayan proqram yaz.
	System.out.println("eded daxil edin: ");
	int y=sc.nextInt();
	if(y%2==0) {
		System.out.println("daxil etdiyiniz eded cutdur");
	}
	else {
		System.out.println("daxil etdiyiniz eded tekdir");
	}
	
	
	
	//10)1-200 aralığında olan tam ədədlərdən həm 3-ə həm də 7-yə qalıqsız bölünənləri konsola çıxaran proqram yaz
	for(int i=1;i<=200;i++) {
		if(i%3==0 && i%7==0) {
			System.out.println(i);
		}
	}
	
	
	
	//11) İlk 20 sadə ədədi konsola çap et.
	int t;
	
for(int i=3;i<=20;i++) {
	r=i/2;
	if(i%r!=0) {
		System.out.println(i);
		
	}
}
	
	
	}
}
