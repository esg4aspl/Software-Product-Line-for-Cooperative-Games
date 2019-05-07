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
	public boolean doesOutbreakMarkerReachedLastSpace() {
		if(markerIndex == (outbreakTrackRange-1)) return true;
		return false;
	}

}
