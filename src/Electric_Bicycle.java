/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
public class Electric_Bicycle extends Land_V_Class implements Engine_V{
	private int gas_consumption;
	private int engine_life;

	public Electric_Bicycle(String model, int max_passengers, int max_speed, String road) {
		super(model, max_passengers, max_speed, 2, road);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getGas_Consumption() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public void setGas_consumption(int gas_consumption) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getExpected_Life() {
		// TODO Auto-generated method stub
		return engine_life;
	}

	@Override
	public void setExpected_Life(int engine_life) {
		// TODO Auto-generated method stub
		this.engine_life=engine_life;
		
	}
	/* return string of Electric bike Object
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Electric Bicycle: " + super.toString() + ", Gas Consumption: " + 
				getGas_Consumption() + "L, Lifetime of " + engine_life + " years .";
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
		Electric_Bicycle other = (Electric_Bicycle) obj;
		if (engine_life != other.engine_life)
			return false;
		if (gas_consumption != other.gas_consumption)
			return false;
		return true;
	}

}
