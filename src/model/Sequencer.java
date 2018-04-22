package model;

import java.util.Queue;

public class Sequencer extends Component {

	private Queue<Byte> data;

	public Sequencer(Component previous) {
		this.previous = previous;
	}
	
	public Sequencer(Component previous, String name) {
		this.previous = previous;
		this.name = name;
	}
	
	public Sequencer(Component previous, Queue<Byte> data) {
		this.previous = previous;
		this.data = data;
	}
	
	public Sequencer(Component previous, Queue<Byte> data, String name) {
		this.previous = previous;
		this.data = data;
		this.name = name;
	}
	
	public Sequencer(Queue<Byte> data) {
		previous = new Component();
		previous.giveData((byte) 0);
		this.data = data;
	}
	
	public Sequencer(Queue<Byte> data, String name) {
		previous = new Component();
		previous.giveData((byte) 0);
		this.data = data;
		this.name = name;
	}

	public Byte processData() {
		data.offer(data.poll());
		return data.peek();
	}

}
