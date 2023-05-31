/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
public class Jeep extends Land_V_Class implements Land_V, Engine_V, Commercial_Use_V {

	private int engine_life;
	private int gas_consumption;

	public Jeep(String model,int gas_c,int max_speed,int engine_life)
	{
		super(model, 5, max_speed, 4, "Dirt Road");
		this.setExpected_Life(engine_life);
	}
	/* get commercial license type
	 * @see Vehicles.Commercial_Use_V#getLicense_Type()
	 */
	@Override
	public String getLicense_Type() {
		return "MINI";
	}

	/* get avg gas consumption
	 * @see Vehicles.Engine_V#getGas_Consumption()
	 */
	@Override
	public int getGas_Consumption() {
		return this.gas_consumption;
	}

	/* set avg gas consumption
	 * @see Vehicles.Engine_V#setGas_consumption(int)
	 */
	@Override
	public void setGas_consumption(int gas_consumption) {
		this.gas_consumption = gas_consumption;
	}

	/* get engine expected life
	 * @see Vehicles.Engine_V#getExpected_Life()
	 */
	@Override
	public int getExpected_Life() {
		return this.engine_life;
	}

	public void setExpected_Life(int engine_life)
	{
		this.engine_life = engine_life;
	}

	/* return string of Jeep Object
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Jeep: " + super.toString() + ", Gas Consumption: " + 
				getGas_Consumption() + "L, Lifetime of " + engine_life + " years , License Type: " + getLicense_Type() + ".";
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
		Jeep other = (Jeep) obj;
		if (engine_life != other.engine_life)
			return false;
		if (gas_consumption != other.gas_consumption)
			return false;
		return true;
	}

}
