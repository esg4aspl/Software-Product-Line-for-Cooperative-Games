package EM_plugin;

import EM_plugin.Generator.DiceGenerator;
import EM_plugin.Generator.FigureGenerator;
import EM_plugin.Generator.GeneratorPlugInI;
import EM_plugin.Generator.PawnGenerator;
import EM_plugin.Generator.PlayerGenerator;

public class App {

	public static void main(String[] args) {
		GameConfig game = new GameConfig();
		
		GeneratorPlugInI players = new PlayerGenerator(2);
		GeneratorPlugInI pawns = new PawnGenerator(4);
		GeneratorPlugInI dices = new DiceGenerator(2);
		GeneratorPlugInI figures = new FigureGenerator(27);
		
		game.registerPlugIn(players);
		game.registerPlugIn(pawns);
		game.registerPlugIn(dices);
		game.registerPlugIn(figures);
		game.start();
		
	
		
	}

}
