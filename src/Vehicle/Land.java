package Vehicle;

public class Land extends s_Land implements Commercial,Motorized,NotMotorized{
    private int num_wheels;
    private int road;//1-paved, 2-dirt

    private int fuel;
    private String energyScore;
    private int engine_lifeTime;
    private String powerSource;
    private String energy_score;//a,b,c
    private String type_lisnce;//mini,limit,unlimit

    public Land(String model_name,int distance, int maxPassenger, int maxSpeed, int totalDistance, int num_wheels, int road)
    {
        super(model_name,distance,maxPassenger,maxSpeed,totalDistance);
        this.num_wheels=num_wheels;
        if(road==1 || road==2)
            this.road=road;
    }
    public int get_number_of_wheels(){
        return num_wheels;
    }

    public void set_number_of_wheels(int num_wheels){
        this.num_wheels=num_wheels;
    }
    public String kind_of_way()
    {
        if(road==1)
            return "A paved road";
        if(road==2)
            return "dirt road";
        return "none";
    }

    public boolean set_road(int road) {
        if (road == 1 || road == 2) {
            this.road = road;
            return true;
        }
        return false;
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

    public String get_license_type() {
        return type_lisnce;
    }
}
