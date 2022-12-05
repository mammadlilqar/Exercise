package pass_by_reference;

public class MainClass {
	public static void main(String[] args) {
		Person p1 = new Person("Sahil", "Esedov", 3, "512344567");
		
		SalaryCalculator s = new SalaryCalculator();
		s.calculateSalary(p1);
		p1.printInfo(p1.name,p1.surname,p1.experienceYear,p1.salary,p1.phone);
	}

	
}
