package EM_plugin.Generator;

import java.util.ArrayList;

import Component.Dice;

public class DiceGenerator implements GeneratorPlugInI {
	private int count;
	
	Dice dice;
	
	ArrayList<Dice> dices = new ArrayList<Dice>();
	
	public DiceGenerator(int count) {
		setParam(count);
	}
	
	
	public ArrayList<Dice> getDices() {
		return dices;
	}


	public void setDices(ArrayList<Dice> dices) {
		this.dices = dices;
	}


	@Override
	public void setParam(String type, int count) {
		
	}

	@Override
	public void setParam(int count) {
		this.count = count;
	}

	@Override
	public ArrayList<?> generate() {
		for(int i=0;i<count;i++) {
			this.dice = new Dice();
			this.dices.add(dice);
		}
		return this.dices;
	}

	@Override
	public void show() {
		this.generate();
		System.out.println("Number of dices: " + count);
		
	}

}
