package EM_plugin.Generator;

import java.util.ArrayList;

import Component.Marker;

public class MarkerGenerator implements GeneratorPlugInI {
	

	int count;
	Marker marker;
	
	
	ArrayList<Marker> markers = new ArrayList<Marker>();
	
	public ArrayList<Marker> getMarkers() {
		return markers;
	}

	public void setMarkers(ArrayList<Marker> markers) {
		this.markers = markers;
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
			marker = new Marker(i);
			this.markers.add(marker);
		}	
		return this.markers;
	}

	@Override
	public void show() {
		this.generate();
		System.out.println("Number of markers: " + count);
	}
}
