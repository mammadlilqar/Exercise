package umumi_praktika;

public class MainClass {
	public static void main(String[] args) {
		String sentence="Java is a high-level and class-based and object-oriented "
				+ "programming language that is designed "
				+ "to have as few implementation dependencies as possible";
		
		//1.Davamında bu sətirdə neçə simvol olduğunu tap.
		
		
		int length=sentence.length();
		System.out.println(length);
	System.out.println("-----------------");
	
	//2.Davamında bu sətirdə neçə söz olduğunu tap.
	String[] sozler=sentence.split(" ");
	System.out.println(sozler.length);
	
	
	
	System.out.println("-----------------");
	//3.Davamında bu sətirin ram-da neçə bit tutduğunu konsolda çap et.
	byte[] bytes=sentence.getBytes();
	for (byte b : bytes) {
		System.out.print(b);
	}
	

	//4.Davamında bu sətirin daxilində ilk 'b' simvolunun neçənci indeksdə olduğunu tap.
	System.out.println("/n");
	System.out.println("-----------------");
	int index=sentence.indexOf('b');
	System.out.println(index);
	
	System.out.println("-----------------");
	//5.Davamında bu sətirin bütün simvollarını kiçik simvola çevir.
	String sentence2=sentence.toLowerCase();
	System.out.println(sentence2);
	
	System.out.println("-----------------");
	
	//6.Davamında bu sətirin bütün simvollarını böyük simvola çevir.
	String sentence3=sentence.toUpperCase();
	System.out.println(sentence3);
	
	System.out.println("-----------------");
	
	//7.Davamında bu sətirin daxilində "class" sözünün olub-olmadığını tap.
	System.out.println("Setirde class sozu varmi? :"+sentence.contains("class-based"));
    System.out.println("-----------------");
	
	
	
	
	}

}
