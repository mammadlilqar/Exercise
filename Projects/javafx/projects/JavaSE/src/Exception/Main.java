package Exception;

import java.util.Stack;

public class Main {
public static void main(String[] args) {
	Stack<Integer> a=new Stack<>();
a.add(3);
a.add(12);
a.add(13);
a.remove(1);

System.out.println(a);
}
}
