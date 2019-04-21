package pandemicBase;

import core.AbstractTrack;

public class OutbreakTrack extends AbstractTrack {
	private int outbreakTrackRange;
	public OutbreakTrack(int range) {
		super();
		setOutbreakTrackRange(range);
	}
	public int getOutbreakTrackRange() {
		return outbreakTrackRange;
	}
	private void setOutbreakTrackRange(int outbreakTrackRange) {
		this.outbreakTrackRange = outbreakTrackRange;
	}
	
	
}
