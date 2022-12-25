package ders_14;

public class Main {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.id = 4;
		e1.name = "Nadir";
		e1.surname = "Memmedov";
		e1.age = 29;
		e1.adress = "Baki seheri Nesimi rayonu ev 34";
		e1.salary = 1234;
		e1.username = "NadirMammedov";
		e1.password = "Nadir1993";
		e1.phone = "0718345678";
		e1.department = "dea";

		e1.printInfo();
	}
}
