package blog.rmi.using;

import blog.rmi.utils.Math;

public class Calculator {
	public static void main(String [] args){
		Math math = new Math();
		System.out.println(math.add(3,4));
		System.out.println(math.add(5,6));
	}
}
