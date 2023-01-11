package ev_tapsirigi_ders18;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tarixler {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Hazırki ayı tapan proqram yaz.");
		System.out.println(now.getMonth());
        System.out.println("Hazırki ili tapan proqram yaz.");
	    System.out.println(now.getYear());
	    System.out.println("Hazırki ayın gününü tapan proqram yaz.");
	    System.out.println(now.getDayOfMonth());
	    System.out.println("Hazırki ilin neçənci həftəsinin olduğunu tapan proqram yaz.");
	    System.out.println("Hazırki saatı tapan proqram yaz.");
	    System.out.println(now.getHour());
	    System.out.println("Hazırki dəqiqəni tapan proqram yaz.");  
	    System.out.println(now.getMinute());
	    System.out.println("Hazırki saniyəni tapan proqram yaz.");
	    System.out.println(now.getSecond());
	    System.out.println("İndidən 3 il əvvəli tap.");
	    System.out.println(now.plusYears(-3));
	  
	  
	
	}
}
