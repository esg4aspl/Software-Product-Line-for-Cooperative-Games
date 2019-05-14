package pandemicBase;

import core.AbstractTrack;

public class OutbreakTrack extends AbstractTrack {
	private int outbreakTrackRange;
	public OutbreakTrack(int range) {
		super();
		this.outbreakTrackRange = range;
	}
	public int getOutbreakTrackRange() {
		return outbreakTrackRange;
	}
	@Override
	public boolean didMarkerReachedLastSpace() {
		if(markerIndex >= outbreakTrackRange) {
			return true;
		}
		return false;
	}
	public String toString() {
		return "Outbreak marker is in " + markerIndex + ". place \n";
	}
}
