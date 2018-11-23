package EM_plugin.Generator;

import java.util.ArrayList;

import Component.Pawn;

public class PawnGenerator implements GeneratorPlugInI {
	int count;
	Pawn pawn;
	ArrayList<Pawn> pawns = new ArrayList<Pawn>();
	
	public PawnGenerator(int count){
		setParam(count);
	}
	
	@Override
	public void setParam(String type, int count) {

	}

	@Override
	public void setParam(int count) {
		this.count = count;
	}

	
	
	public ArrayList<Pawn> getPawns() {
		return pawns;
	}

	public void setPawns(ArrayList<Pawn> pawns) {
		this.pawns = pawns;
	}

	@Override
	public ArrayList<?> generate() {
		for(int i = 0; i<this.count ; i++) {
			pawn = new Pawn(i);
			this.pawns.add(pawn);
		}
		return this.pawns;
	}

	@Override
	public void show() {
		this.generate();
		System.out.println("Number of pawns: " + count);
	}

}
