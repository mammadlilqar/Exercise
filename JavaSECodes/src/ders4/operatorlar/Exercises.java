package ders4.operatorlar;

public class Exercises {
	public static void main(String[] args) {
		// 1.İki ədədi cəmləyən və nəticəsini konsola çıxardan proqram:
		int a = 34, b = 12, c;
		c = a + b;
		System.out.println(a + "+" + b + "=" + c);

		// 2.İki ədədi bir birinə vuran və nəticəsini konsola çıxardan proqram:
		int d = 8, e = 12, f;
		f = d * e;
		System.out.println(d + "*" + e + "=" + f);

		// 3.Çevrənin radiusuna görə onun uzunluğunu hesablayan proqram:
		int r = 12, l;
		l = 2 * 3 * r;
		System.out.println("Çevrənin uzunluğu:" + l);

		// 4.Dairənin radiusuna görə onun sahəsini hesablayan proqram:
		int radius = 7, s;
		s = 3 * radius * radius;
		System.out.println("Dairənin sahəsi:" + s);

		/*
		 * 5.int tipində və number adında dəyişən yarat, bu dəyişənə 37 dəyərini
		 * mənimsət, bu dəyişənin dəyərini 3-ə vur, bu dəyişənin dəyərinin 5-ə
		 * bölünməsindən alınan qalığı tap
		 */
		int number = 37;
		System.out.println("qaliq:" + (number * 3) % 5);

		/*
		 * int tipində dəyişən yarat və bu dəyişənə istədiyin dəyəri mənimsət. bu
		 * dəyişənin dəyərinin 3-ə və 7-yə qalıqsız bölünüb bölünməməsini tap.
		 */
		int variable = 23,qaliq1,qaliq2;
		qaliq1=variable%3;
		qaliq2=variable%7;
		
        if(qaliq1==0 && qaliq2==0) {
        	System.out.println("eded hem 3-e hem de 7-e qaliqsiz bolunur");
        }
        else {
        	System.out.println("eded ya her iki edede yada ikisinden birine qalisiz bolunmur");
        }
	}
}
