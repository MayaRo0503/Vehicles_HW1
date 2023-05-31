/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
public class Glider_Game extends Air_V_Class implements Air_V, No_Engine_V {

	private String power_source;
	private char energetic_score;
	
	public Glider_Game()
	{
		super("Toy", 0, 10, "Civilian");
		this.energetic_score = 'A';
		this.power_source = "Manual";
	}
	
	@Override
	public String getPower_Source() {
		return this.power_source;
	}

	@Override
	public char getEnergetic_Score() {
		return this.energetic_score;
	}

	@Override
	public String toString() {
		return "Glider_Game: " + super.toString() +  " Power source: " + power_source + ", Energetic Score: " + energetic_score + ".";
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
		if (!(obj instanceof Glider_Game))
			return false;
		Glider_Game other = (Glider_Game) obj;
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
