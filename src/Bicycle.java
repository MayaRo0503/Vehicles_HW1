/*
Maya Rozenberg - 313381600
Doron Shpitzer -313262594
 */
public class Bicycle extends Land_V_Class implements No_Engine_V {

	
	public Bicycle(String model, int max_passengers, int max_speed, String road) {
		super(model, max_passengers, max_speed, 2, road);
	}

	@Override
	public String getPower_Source() {
		return "Manual";
	}

	@Override
	public char getEnergetic_Score() {
		return 'A';
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bicycle: " + super.toString() + "Power Source: Manual, Energetic Score: A.";
	}
}
