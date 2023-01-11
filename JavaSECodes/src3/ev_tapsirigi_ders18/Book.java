package ev_tapsirigi_ders18;

public class Book {
public String name;
public int price;
String key=new String();
public void bookPrice(double amount) {
	synchronized (key) {
	price+=amount;	
	}
	
}

}
