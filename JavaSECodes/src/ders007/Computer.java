package ders007;

public class Computer {
    //1.Computer adında yeni bir sinif yarat və daxilində 
    //Integer id; String brand; String model; String color;dəyişənlərini yarat

	int id;
	String brand;
	String model;
	String color;

	// 2.Computer sinifinin daxilində 3 ədəd qurucu konstruktor yarat.
	// 1-ci default, 2-ci model qəbul edən, 3-cü model və color qəbul edən.
	// Hər bir constructorun daxilində parametrdən gələn dəyərləri konsola çap et.
	// Həmçinin parametrdən gələn dəyərləri obyektin dəyişənlərinə mənimsət
	Computer() {

	}

	Computer(String m) {
		System.out.println(m);
	}

	Computer(String m, String c) {
		System.out.println(m + "-" + c);
	}

}
