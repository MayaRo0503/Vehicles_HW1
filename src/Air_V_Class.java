/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
public class Air_V_Class extends T_Vehicle {

	protected String type;
	
	public Air_V_Class(String model, int max_passengers, int max_speed, String type) {
		super(model, max_passengers, max_speed);
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
		if (!(obj instanceof Air_V_Class))
			return false;
		Air_V_Class other = (Air_V_Class) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "Type: " + type;
	}

	
}
