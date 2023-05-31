/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
public class HybridAircraft extends Amphibian implements Engine_V,Air_V {

	private int gas_consumption;
	private int engine_life;
	public HybridAircraft(String model, int max_passengers, int max_speed,  int wheels_num, String flag, int engine_life, int gas_consumption) {
		super(model, max_passengers,  max_speed, wheels_num, flag,  engine_life,  gas_consumption);		
	}
	@Override
	public int getGas_Consumption() {
		return this.gas_consumption;
	}
	@Override
	public void setGas_consumption(int gas_consumption) {
		this.gas_consumption=gas_consumption;

	}
	@Override
	public int getExpected_Life() {
		// TODO Auto-generated method stub
		return this.engine_life;
	}
	@Override
	public void setExpected_Life(int engine_life) {
		// TODO Auto-generated method stub
		this.engine_life=engine_life;

	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Military";
	}
	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub

	}
	/* return string of HybridAircraft Object
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Hybrid Aircraft: " + super.toString() +",type :"+getType();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof HybridAircraft))
			return false;
		HybridAircraft other = (HybridAircraft) obj;
		if (engine_life != other.engine_life)
			return false;
		if (gas_consumption != other.gas_consumption)
			return false;
		return true;
	}




}