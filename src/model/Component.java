package model;

import java.util.Queue;
import java.util.LinkedList;

public class Component {
	protected Component previous;
	protected String name;
	protected int delay;
	protected Queue<Byte> data;
	
	public Component() {
		name = "blank";
		data = new LinkedList<Byte>();
		delay = 1;
	}
	
	public Component(Component previous) {
		this.previous = previous;
		name = "blank";
		data = new LinkedList<Byte>();
		delay = 1;
	}
	
	public Component(Component previous, String name) {
		this.previous = previous;
		this.name = name;
		data = new LinkedList<Byte>();
		delay = 1;
	}
	
	public Component(Component previous, int delay) {
		this.previous = previous;
		name = "blank";
		data = new LinkedList<Byte>();
		this.delay = delay;
	}
	
	public Component(Component previous, String name, int delay) {
		this.previous = previous;
		this.name = name;
		data = new LinkedList<Byte>();
		this.delay = delay;
	}
	
	public Queue<Byte> getData() {
		return data;
	}
	
	public Byte getFromData() { 
		return data.poll();
	}
	
	public void giveData(Byte data) {
		this.data.offer(data);
	}
	
	public Byte processData() {
		Byte hold = previous.processData();
		if(hold != null) {
			data.offer(hold);
		}
		if(data.size() > delay)
			return data.poll();
		return null;
	}
}
