/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */

public class Frigate extends Water_V_Class implements Engine_V {

	private int engine_life;
	private int gas_consumption;

	public Frigate(String model, int max_speed, int max_passengers, String with_wind_dir)
	{
		super(model, max_passengers, max_speed, with_wind_dir, "Israel");
		gas_consumption = 500;
		engine_life = 4;
	}
	
	@Override
	public int getGas_Consumption() {
		return this.gas_consumption;
	}

	@Override
	public void setGas_consumption(int gas_consumption) {
		this.gas_consumption = gas_consumption;
	}

	@Override
	public int getExpected_Life() {
		return this.engine_life;
	}

	@Override
	public void setExpected_Life(int engine_life) {
		this.engine_life = engine_life;
	}

	/* Prigta tostring
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Frigate: " + super.toString() + ", Engine: " + gas_consumption
				+ "L, Lifetime of " + engine_life + " years.";
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
		if (getClass() != obj.getClass())
			return false;
		Frigate other = (Frigate) obj;
		if (engine_life != other.engine_life)
			return false;
		if (gas_consumption != other.gas_consumption)
			return false;
		return true;
	}


}
