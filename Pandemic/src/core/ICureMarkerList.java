package core;

import java.util.List;

public interface ICureMarkerList {
	public List<AbstractGamePiece> getCureMarkerList();
	public void addCureMarker(AbstractGamePiece marker);
	public AbstractGamePiece getMarkerByColor(Color color);
	public boolean areAllMarkersCured();
	public List<AbstractGamePiece> getCuredMarkers();
	public String showCureMarkerListStatue();
}
