package pandemicBase;

import common.AbstractMeter;

public class Outbreakmeter extends AbstractMeter{

	public Outbreakmeter(int range) {
		super(range);
		setMeterArray(generateMeterArray());
		// TODO Auto-generated constructor stub
	}

	private int[] generateMeterArray() {
		int range=this.getRange();
		int meterArray[] = new int[range]; 
	    /** Creates a new instance of Array */
	    for(int i=0;i<range;i++) {
	    	meterArray[i]=i;
	    
	    }
	    
	    return meterArray;
	    
	}

}