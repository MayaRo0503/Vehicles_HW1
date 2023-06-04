/*
Maya Rozenberg - 313381600
Doron Shpitzer -313262594
 */
public class Water_V_Class extends T_Vehicle implements Water_V {

	protected String with_wind_dir;
	protected String flag;
	
	public Water_V_Class(String model, int max_passengers, int max_speed, String with_wind_dir, String flag) {
		super(model, max_passengers, max_speed);
		this.with_wind_dir = with_wind_dir;
		this.flag = flag;
	}

	/**
	 * @return the with_wind_dir
	 */
	public String getWith_wind_dir() {
		return with_wind_dir;
	}

	/**
	 * @param with_wind_dir the with_wind_dir to set
	 */
	public void setWith_wind_dir(String with_wind_dir) {
		this.with_wind_dir = with_wind_dir;
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
		if (!(obj instanceof Water_V_Class))
			return false;
		Water_V_Class other = (Water_V_Class) obj;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (with_wind_dir == null) {
			if (other.with_wind_dir != null)
				return false;
		} else if (!with_wind_dir.equals(other.with_wind_dir))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "Flag: " + flag + ", " + with_wind_dir + " wind direction ";
	}
	
	@Override
	public String is_With_Wind_Dir() {
		return with_wind_dir;
	}

	@Override
	public void Set_Wind_Dir(String with_wind_dir) {
		this.with_wind_dir = with_wind_dir;
	}
}
