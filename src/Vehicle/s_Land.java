package Vehicle;

public abstract class s_Land extends Vehicles{
    public s_Land(String model_name,int distance, int maxPassenger, int maxSpeed, int totalDistance) {
        super(model_name, distance, maxPassenger, maxSpeed, totalDistance);
    }
    abstract public int get_number_of_wheels();
    abstract public String kind_of_way();
}
