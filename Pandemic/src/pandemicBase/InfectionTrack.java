package pandemicBase;

import core.AbstractTrack;

public class InfectionTrack extends AbstractTrack {
	private int[] infectionTrackValues;

	public InfectionTrack(int[] infectionTrackValues) {
		super();
		this.infectionTrackValues = infectionTrackValues;
	}
	public int getNumberOfCitiesWillBeInfected() {
		return infectionTrackValues[markerIndex];
	}
	
}
