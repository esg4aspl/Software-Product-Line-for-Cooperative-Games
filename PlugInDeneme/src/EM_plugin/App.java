package EM_plugin;

import java.io.FileNotFoundException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import EM_Config.ConfigWriter;
import EM_plugin.Generator.DiceGenerator;
import EM_plugin.Generator.FigureGenerator;
import EM_plugin.Generator.GeneratorPlugInI;
import EM_plugin.Generator.PawnGenerator;
import EM_plugin.Generator.PlayerGenerator;

public class App {

	public static void main(String[] args) throws InvalidFormatException, ParserConfigurationException, TransformerException, FileNotFoundException {
		/*
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
		
		*/
		
		ConfigWriter configWriter = new ConfigWriter();
	    configWriter.write("Features.txt");
		
	}

}
