package common;

public abstract class AbstractMeter {
	private int range;
	private int[] meterArray;
	
	public AbstractMeter(int range) {
		setRange(range);
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int[] getMeterArray() {
		return meterArray;
	}

	public void setMeterArray(int[] meterArray) {
		this.meterArray = meterArray;//bu set methodu override edilecek
	}
		
	
	

}
