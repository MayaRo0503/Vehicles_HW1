/*
Maya Rozenberg - 313381600
Doron Shpitzer -313262594
 */

public class Glider_Spy extends Air_V_Class implements No_Engine_V {

	private String power_source;
	private char energetic_score;
	
	public Glider_Spy(String power_source)
	{
		super("Classified", 1, 50, "Military");
		this.energetic_score = 'C';
		this.power_source = power_source;
	}
	
	@Override
	public String getPower_Source() {
		return power_source;
	}

	@Override
	public char getEnergetic_Score() {
		return this.energetic_score;
	}

	@Override
	public String toString() {
		return "Glider_Spy: " + super.toString() +  "Power source: " + power_source + ", Energetic Score: " + energetic_score + ".";
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Glider_Spy))
			return false;
		Glider_Spy other = (Glider_Spy) obj;
		if (energetic_score != other.energetic_score)
			return false;
		if (power_source == null) {
			if (other.power_source != null)
				return false;
		} else if (!power_source.equals(other.power_source))
			return false;
		return true;
	}

	
}
