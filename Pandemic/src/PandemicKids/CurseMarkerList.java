package PandemicKids;

import core.AbstractGamePiece;
import pandemicBase.CureMarker;
import pandemicBase.CureMarkerList;

public class CurseMarkerList extends CureMarkerList {
	public boolean areAllCurseMarkersEradicated() {
		boolean isEradicated = true;
		for (AbstractGamePiece marker : getCureMarkerList()) {
			isEradicated = isEradicated &&((CureMarker)marker).isEradicated() ;
		}
		return isEradicated;
	}
	@Override
	public String showCureMarkerListStatue() {
		String statue = "";
		for (AbstractGamePiece piece : cureMarkerList) {
			statue = statue + "CURSE MARKER COLOR: "+((CureMarker)piece).getColor()+ " isEradicated?: " + ((CureMarker)piece).isEradicated()  + "\n";
		}
		return statue;
	}
}
