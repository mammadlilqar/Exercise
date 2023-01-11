package ev_tapsirigi_ders18;

public class MyThread extends Thread{
Book b;
public MyThread(Book b) {
	this.b=b;
}
@Override
	public void  run() {
		 b.bookPrice(1);
		
	}
}
