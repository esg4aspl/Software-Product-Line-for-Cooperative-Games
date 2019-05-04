package pandemicBase;

import java.util.ArrayList;
import java.util.List;

import core.AbstractGamePiece;
import core.Color;
import core.ICureMarkerList;

public class CureMarkerList implements ICureMarkerList {
	List<AbstractGamePiece> cureMarkerList;
	public CureMarkerList() {
		cureMarkerList = new ArrayList<AbstractGamePiece>();
	}
	
	@Override
	public void addCureMarker(AbstractGamePiece marker) {
		cureMarkerList.add(marker);
	}
	@Override
	public AbstractGamePiece getMarkerByColor(Color color) {
		for (AbstractGamePiece marker : cureMarkerList) {
			if(((CureMarker)marker).getColor().equals(color)){
				return marker;
			}
		}
		return null;
	}
}
