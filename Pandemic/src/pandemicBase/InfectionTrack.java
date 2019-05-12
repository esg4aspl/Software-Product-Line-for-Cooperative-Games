package pandemicBase;

import core.AbstractTrack;

public class InfectionTrack extends AbstractTrack {
	private int[] infectionTrackValues;

	public InfectionTrack(int[] infectionTrackValues) {
		super();
		this.infectionTrackValues = infectionTrackValues;
	}
	public int getNumberOfCitiesWillBeInfected() {
		if(!didMarkerReachedLastSpace()) {
			return infectionTrackValues[markerIndex];
		}
		return infectionTrackValues[infectionTrackValues.length-1];
	}
	@Override
	public boolean didMarkerReachedLastSpace() {
		if(markerIndex < infectionTrackValues.length) return false;
		return true;
	}
	
	
}
