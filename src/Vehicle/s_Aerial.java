package Vehicle;

public abstract class s_Aerial extends Vehicles {
    public s_Aerial(String model_name,int distance, int maxPassenger, int maxSpeed, int totalDistance) {
        super(model_name, distance, maxPassenger, maxSpeed, totalDistance);
    }
    abstract public String military_or_civilian ();
}
