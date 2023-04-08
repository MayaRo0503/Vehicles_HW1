package Vehicle;

public class Marine extends s_Marine implements Commercial,Motorized,NotMotorized {
    private int sailingDirection;//2-with the wind , 1-not
    private String flag;
    private int fuel;
    private String energyScore;
    private int engine_lifeTime;
    private String powerSource;
    private String energy_score;//a,b,c
    private String type_lisnce;//mini,limit,unlimit

    public Marine(String model_name,int distance, int maxPassenger, int maxSpeed, int totalDistance,int sailingDirection, String flag)
    {
        super(model_name,distance,maxPassenger,maxSpeed,totalDistance);
        if(sailingDirection==2 ||sailingDirection==1)
            this.sailingDirection=sailingDirection;
        this.flag=flag;
    }

    public void setSailingDirection(int sailingDirection)
    {
        if(sailingDirection==2 || sailingDirection==1)
            this.sailingDirection=sailingDirection;
    }

    public void setFlag(String flag)
    {
        this.flag=flag;
    }
    public int sailing_direction(){
        return sailingDirection;
    }
    public String get_country_flag()
    {
        return flag;
    }



    public int get_fuel_consumption() {
        return this.fuel;
    }

    public void set_fuel_consumption(int fuel) {
        this.fuel=fuel;
    }

    public int get_engine_life_time() {
        return this.engine_lifeTime;
    }

    public String get_power_source() {
        if(fuel==0)
            return powerSource;
        return "Not motorized";
    }

    public String get_energy_score() {
        if(fuel==0)
            return this.energy_score;
        return "Not motorized";
    }

    @Override
    public String get_license_type() {
        return type_lisnce;
    }
}
