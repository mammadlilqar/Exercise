package ders11massiv;

import java.util.Arrays;

public class evIsi {
public static void main(String[] args) {

	int[] array=new int[10];
	for ( int i = 0; i <10; i++) {
array[i]=i+1;

	}
	int a=0;
	int[] tekler=new int[array.length] ;
	int[] cutler=new int[array.length] ;
	for (int i = 0; i < array.length; i++) {
		if(array[i]%2!=0) {
		
		tekler[a]=array[i];
        a++;
		
		
		}
		else
			cutler[a]=array[i];
		
		}
for (int i = 0; i < tekler.length; i++) {
	System.out.println(tekler[i]);
}

	
}
}		

