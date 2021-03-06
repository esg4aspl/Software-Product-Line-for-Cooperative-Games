package pandemicBase;

import java.util.ArrayList;
import java.util.List;

import core.AbstractGamePiece;
import core.Color;
import core.ICureMarkerList;

public class CureMarkerList implements ICureMarkerList {
	protected List<AbstractGamePiece> cureMarkerList;
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

	@Override
	public boolean areAllMarkersCured() {
		boolean curedMarkerFlag= true;
		for (AbstractGamePiece marker : cureMarkerList) {
			curedMarkerFlag = curedMarkerFlag && ((CureMarker)marker).isCured();
			
		}
		return curedMarkerFlag;
	}

	@Override
	public List<AbstractGamePiece> getCuredMarkers() {
		List<AbstractGamePiece> curedMarkers = new ArrayList<AbstractGamePiece>();
		for (AbstractGamePiece marker : cureMarkerList) {
			if(((CureMarker)marker).isCured()) {
				curedMarkers.add(marker);
			}
		}
		return curedMarkers;
	}

	@Override
	public String showCureMarkerListStatue() {
		String statue = "";
		for (AbstractGamePiece piece : cureMarkerList) {
			statue = statue + "Cure Marker List: "+((CureMarker)piece).getColor()+ " isCured?: " +((CureMarker)piece).isCured() + " isEradicated?: " + ((CureMarker)piece).isEradicated()  + "\n";
		}
		return statue;
	}

	@Override
	public List<AbstractGamePiece> getCureMarkerList() {
		return cureMarkerList;
	}
	
}
