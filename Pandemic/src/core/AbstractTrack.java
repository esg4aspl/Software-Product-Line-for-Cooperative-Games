package core;

public abstract class AbstractTrack {
	protected int markerIndex;
	public AbstractTrack() {
		this.markerIndex = 0;
	}
	public void moveMarker() {
		this.markerIndex++;
	}
	public abstract boolean didMarkerReachedLastSpace();
}
