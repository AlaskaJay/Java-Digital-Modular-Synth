package testing;

import java.util.LinkedList;
import java.util.Queue;

import model.Component;
import model.Sequencer;

public class ComponentTesting {

	public static void main(String[] args) {
		Queue<Byte> sequence = new LinkedList<Byte>();
		
		for(Byte i = 0; i < 10; i++)
			sequence.offer((byte) (i+100));
		
		Component feed = new Component(new Component(new Component(new Sequencer(sequence, "squencer"), "delay", 10), "between 2", 0), "feed");
		
		for(int i = 0; i < 100; i++) {
			System.out.println(i +"," + feed.processData());
		}
	}

}
