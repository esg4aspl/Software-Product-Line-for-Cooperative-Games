package EM_plugin.Generator;

import java.util.ArrayList;

import Component.Player;

public class PlayerGenerator implements GeneratorPlugInI {
	private int count;
	Player player;
	ArrayList<Player> players = new ArrayList<Player>();
	
	public PlayerGenerator(int count){
		setParam(count);
	}
	
	
	
	public ArrayList<Player> getPlayers() {
		return players;
	}



	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
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
		for(int i = 0; i<this.count ; i++) {
			player = new Player(i);
			this.players.add(player);
		}
		return this.players;
	}

	@Override
	public void show() {
		this.generate();
		this.players.forEach(p-> System.out.println("Player has been created with ID : " + p.getID()));
		System.out.println("Total number of players: " + this.count);
	}

}
