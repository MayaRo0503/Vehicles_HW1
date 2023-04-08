package Vehicle;

public class Aerial extends s_Aerial implements Commercial,Motorized,NotMotorized {
    private int use;//2-military,1-civil
    private String type_lisnce;//mini,limit,unlimit
    private int fuel;
    private String energyScore;
    private int engine_lifeTime;
    private String powerSource;
    private String energy_score;//a,b,c
    public Aerial(String model_name,int distance, int maxPassenger, int maxSpeed, int totalDistance,int use,String type_lisnce)
    {
        super(model_name,distance,maxPassenger,maxSpeed,totalDistance);
        if(use==2 || use==1)
            this.use=use;
        this.type_lisnce=type_lisnce;
    }

    public String military_or_civilian()
    {
        if(use == 1)
            return "Civilian";
        if(use == 2)
            return "Military";
        return "none";
    }

    public boolean set_military_or_civilian(int use)
    {
        if(use==1 || use==2)
        {
            this.use=use;
            return true;
        }
        return false;
    }


    public String get_license_type() {
        return this.type_lisnce;
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
}
