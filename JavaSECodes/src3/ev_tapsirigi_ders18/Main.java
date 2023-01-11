package ev_tapsirigi_ders18;

public class Main {
public static void main(String[] args) throws InterruptedException {
	Book b1=new Book();
	b1.name="Sky Falls";
	b1.price=14;
	MyThread[] thread=new MyThread[20];
for (int i = 0; i < thread.length; i++) {
	thread[i]=new MyThread(b1);
}
for (int i = 0; i < thread.length; i++) {
	thread[i].start();;
}
Thread.sleep(2);
System.out.println(b1.price);
}
}
