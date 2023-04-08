package Vehicle;

public abstract class s_Marine extends Vehicles{

    public s_Marine(String model_name,int distance, int maxPassenger, int maxSpeed, int totalDistance) {
        super(model_name, distance, maxPassenger, maxSpeed, totalDistance);
    }
    abstract public int sailing_direction();
    abstract public String get_country_flag();

}
