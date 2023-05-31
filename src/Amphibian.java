/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
public class Amphibian extends T_Vehicle implements Engine_V, Water_V, Land_V {

	Water_V_Class water_travel;
	Land_V_Class land_travel;

	private int engine_life;
	private int gas_consumption;

	public Amphibian(String model, int max_passengers, int max_speed, int wheels_num, String flag, int engine_life, int gas_consumption) {
		super(model, max_passengers, max_speed);
		land_travel = new Land_V_Class(model, max_passengers, max_speed, wheels_num, "Paved Road");
		water_travel = new Water_V_Class(model, max_passengers, max_speed, "with", flag);
		this.engine_life = engine_life;
		this.gas_consumption = gas_consumption;
	}

	/* get avg gas consumption
	 * @see Vehicles.Engine_V#getGas_Consumption()
	 */
	@Override
	public int getGas_Consumption() {
		return this.gas_consumption;
	}

	/* set avg gas consumption
	 */
	@Override
	public void setGas_consumption(int gas_consumption) {
		this.gas_consumption = gas_consumption;
	}

	/* get engine expected life
	 */
	@Override
	public int getExpected_Life() {
		return this.engine_life;
	}

	public void setExpected_Life(int engine_life)
	{
		this.engine_life = engine_life;
	}
	/* return the number of wheels
	 */

	public int getWheels_num() {
		return land_travel.getWheels_num();
	}

	/* return the road type
	 */

	public String getRoad() {
		return land_travel.getRoad();
	}


	public String is_With_Wind_Dir() {
		return water_travel.getWith_wind_dir();
	}


	public void Set_Wind_Dir(String with_wind_dir) {
		this.water_travel.setWith_wind_dir(with_wind_dir);
	}


	public String getFlag() {
		return water_travel.getFlag();
	}


	public void setFlag(String flag) {
		water_travel.setFlag(flag);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Amphibian: " + water_travel.toString() + "Number of Wheels: " + land_travel.getWheels_num() + ", Engine Life: "
				+ engine_life + ", Gas Consumption: " + gas_consumption + ".";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Amphibian))
			return false;
		Amphibian other = (Amphibian) obj;
		if (engine_life != other.engine_life)
			return false;
		if (gas_consumption != other.gas_consumption)
			return false;
		if (land_travel == null) {
			if (other.land_travel != null)
				return false;
		} else if (!land_travel.equals(other.land_travel))
			return false;
		if (water_travel == null) {
			if (other.water_travel != null)
				return false;
		} else if (!water_travel.equals(other.water_travel))
			return false;
		return true;
	}



}
