public class Connection {
    //le private fields. no snooping around here
    private String lineColour;
    private String fromStation;
    private String destinationStation;
    private double travelTime;
// bro has learned about what a constructor is
    public Connection(String lineColour, String fromStation, String destinationStation, double travelTime){
        this.lineColour = lineColour;
        this.fromStation = fromStation;
        this.destinationStation = destinationStation;
        this.travelTime = travelTime;
    }
    // getting the getters
    public String getLineColour(){
        return lineColour;
    }
    public String getFromStation(){
        return fromStation;
    }
    public String getDestinationStation(){
        return destinationStation;
    }
    public double getTravelTime(){
        return travelTime;
    }
}
