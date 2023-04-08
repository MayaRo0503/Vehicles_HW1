package Vehicle;
public class Vehicles {
    private String model_name;
    private int distance;
    private int maxPassenger;
    private int maxSpeed;
    private int totalDistance;
    public Vehicles(String model_name,int distance, int maxPassenger, int maxSpeed, int totalDistance)
    {
        this.model_name=model_name;
        this.distance=distance;
        this.maxPassenger=maxPassenger;
        this.maxSpeed=maxSpeed;
        this.totalDistance=totalDistance;
    }
    public String getName() {return model_name;}
    public int getDistance() {return distance;}
    public int getMaxPassenger() {return maxPassenger;}
    public int getMaxSpeed() {return maxSpeed;}
    public int getTotalDistance() {return totalDistance;}

}
