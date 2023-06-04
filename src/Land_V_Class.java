/*
Maya Rozenberg - 313381600
Doron Shpitzer -313262594
 */
public class Land_V_Class extends T_Vehicle {

	private int wheels_num;
	protected String road;
	
	public Land_V_Class(String model, int max_passengers, int max_speed, int wheels_num, String road) {
		super(model, max_passengers, max_speed);
		this.wheels_num = wheels_num;
		this.road = road;
	}

	/**
	 * @return the wheels_num
	 */
	public int getWheels_num() {
		return wheels_num;
	}

	/**
	 * @return the gas_consumption
	 */
	public String getRoad() {
		return road;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "Number of wheels: " + getWheels_num() + ", Road can travel: " + getRoad();
	}
	
}
