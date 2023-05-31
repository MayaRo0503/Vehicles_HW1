/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
public abstract class T_Vehicle {

	private String model;		//Vehicle Model
	private int total_dist;		//Vehicle total distance traveled
	private int max_passengers;	//Vehicle max passengers number
	private int max_speed;		//Vehicle max speed number;
	private String img_src;		//image source
	
	public T_Vehicle(String model, int max_passengers, int max_speed)
	{
		this.model = model;
		this.max_passengers = max_passengers;
		this.max_speed = max_speed;
	}
	/**
	 * @return the movement
	 */
	public void Travel_Distance(int distance) {
		this.total_dist += distance;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the max_passengers
	 */
	public int getMax_passengers() {
		return max_passengers;
	}
	/**
	 * @param max_passengers the max_passengers to set
	 */
	public void setMax_passengers(int max_passengers) {
		this.max_passengers = max_passengers;
	}
	/**
	 * @return the max_speed
	 */
	public int getMax_speed() {
		return max_speed;
	}
	/**
	 * @param max_speed the max_speed to set
	 */
	public void setMax_speed(int max_speed) {
		this.max_speed = max_speed;
	}
	/**
	 * @return the total_dist traveled
	 */
	public int getTotal_dist() {
		return total_dist;
	}
	@Override
	public String toString() {
		return "Model: " + getModel() + ", Traveled: " + getTotal_dist() + ", Max speed of "
				+ getMax_speed() + "Mph , Can carry max of " + getMax_passengers() + " people, ";
	}
	/* check equality
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		T_Vehicle other = (T_Vehicle) obj;
		if (max_passengers != other.max_passengers)
			return false;
		if (max_speed != other.max_speed)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}
	public void resetDistanceTraveled() {
		this.total_dist = 0;
	}
	public void setImageSource(String img_src)
	{
		this.img_src = img_src;
	}
	public String getImageSource()
	{
		return img_src;
	}
}
