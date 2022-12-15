package ders11massiv;

import java.util.Arrays;
import java.util.Iterator;

public class Massiv {
public static void main(String[] args) {
	//dövr istifadə edərək massivin bütün dəyərlərini topla və konsola çap et.
	int[] numbers=new int[6];
	numbers[0]=11;
	numbers[1]=0;
	numbers[2]=6;
	numbers[3]=4;
	numbers[4]=23;
	numbers[5]=15;
int say=numbers.length;
int cem=0;
for (int i = 0; i < say; i++) {
	cem=cem+numbers[i];
}
System.out.println(cem);


//massivin daxilində olan elementlərin ədədi ortasını tap və konsola çap et.
System.out.println("--------");
System.out.println("Ədədi orta:");
double sum=0;
double avg=1;
int say2=numbers.length;
for (int i = 0; i <say2; i++) {
	
	sum=sum+numbers[i];
avg=sum/say2;
}
System.out.println(avg);



//massivin elementlərindən ən kiçiyini tap və konsola çap et.
System.out.println("--------");
System.out.println("Ən kiçik elementin tapılması");
Arrays.sort(numbers);
System.out.println("en kicik element:"+numbers[0]);

	



//massivin elementlərindən tək olanları tap və konsola çap et.
System.out.println("--------");
System.out.println("tek elementler:");
for (int t = 0; t < numbers.length; t++) {
	if(numbers[t]%2!=0) {
		
		System.out.println(numbers[t]);
	}
}



//massivin elementlərindən cüt olanları tap və konsola çap et.
System.out.println("--------");
System.out.println("cut elementler:");
	for (int j = 0; j < numbers.length; j++) {
		if(numbers[j]%2==0) {
			
			System.out.println(numbers[j]);
		}}

//massivin elementlərindən sadə ədəd olanları tap və konsola çap et.
	
	System.out.println("--------");
	int f=0;
	for(int a: numbers) {
		if(a==0 || a==1) {
			System.out.println(a+ "  ne sade ne de murekkeb deyil deyil: ");
		}
		else {
		for(int i=2;i<a-1;i++) {
			if(a%i==0) {
				System.out.println(a+" murekkebdir");
				f=1;
				break;
			}
		}
			
		}
	
	
}if(f==0) {
		System.out.println("qalanlari sadedir");
	}




//massivin elementlərini azalan sıra ilə sırala
	System.out.println("--------");
	System.out.println("Azalan sira ile siralama:");
int b=numbers.length-1;
while(b>=0) {
	System.out.println(numbers[b]);
	b--;
}
	
}

}
