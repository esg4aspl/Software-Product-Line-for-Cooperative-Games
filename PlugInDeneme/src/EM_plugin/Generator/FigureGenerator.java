package EM_plugin.Generator;

import java.util.ArrayList;

import Component.Figure;

public class FigureGenerator implements GeneratorPlugInI {
	int count;
	Figure figure;
	ArrayList<Figure> figures = new ArrayList<Figure>();
	
	public FigureGenerator(int count) {
		setParam(count);
	}
	
	public ArrayList<Figure> getFigures() {
		return figures;
	}

	public void setFigures(ArrayList<Figure> figures) {
		this.figures = figures;
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
			figure = new Figure(i);
			this.figures.add(figure);
		}
		return this.figures;
	}

	@Override
	public void show() {
		this.generate();
		System.out.println("Number of figures: " + count);	
	}

}
