package testing;

import model.Component;

public class InfiniteLoopTesting {

	public static void main(String[] args) {
		
		Component a = new Component("a");
		Component b = new Component(a, "b");
		Component c = new Component(b, "c");
		a.setPrevious(c);
		a.giveData((byte)0);
		a.giveData((byte)1);
		a.giveData((byte)2);
		a.giveData((byte)3);
		for(int i = 4; i < 10; i++) {
			System.out.println("starting tests for " + (i+1));
			a.giveData((byte)i);
			for(int j = 0; j < 10; j++) {
				//CREATES STACK OVERFLOW
				//System.out.println(j + ", " + a.processData());
			}
		}
	}
}
