package EM_plugin;

import java.util.ArrayList;

import EM_plugin.Generator.GeneratorPlugInI;

public class GameConfig {
	ArrayList<GeneratorPlugInI> features = new ArrayList<GeneratorPlugInI>();
	
	public void registerPlugIn(GeneratorPlugInI p) {
		features.add(p);
	}
	
	public void unregisterPlugIn(GeneratorPlugInI p) {
		features.remove(p);
	}
	public void start() {
		this.features.forEach(f -> f.show());
	}

}
