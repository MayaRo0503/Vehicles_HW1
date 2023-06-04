/*
Maya Rozenberg - 313381600
Doron Shpitzer -313262594
 */
public class Cruise_Ship extends Water_V_Class implements Engine_V, Commercial_Use_V {

	int gas_consumption;
	int engine_life;
	public Cruise_Ship(String model, int max_passengers, int max_speed, String flag, int gas_consumption, int engine_life) {
		super(model, max_passengers, max_speed, "with", flag);
		this.gas_consumption = gas_consumption;
		this.engine_life = engine_life;
		}

	@Override
	public String getLicense_Type() {
		return "Unlimited";
	}

	@Override
	public int getGas_Consumption() {
		return gas_consumption;
	}

	@Override
	public void setGas_consumption(int gas_consumption) {
		this.gas_consumption = gas_consumption;
	}

	@Override
	public int getExpected_Life() {
		return engine_life;
	}

	@Override
	public void setExpected_Life(int engine_life) {
		this.engine_life = engine_life;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cruise_Ship: " + super.toString() + "Gas Consumption: " + gas_consumption + ", Engine Life: " + engine_life + ".";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Cruise_Ship))
			return false;
		Cruise_Ship other = (Cruise_Ship) obj;
		if (engine_life != other.engine_life)
			return false;
		if (gas_consumption != other.gas_consumption)
			return false;
		return true;
	}

	
}
