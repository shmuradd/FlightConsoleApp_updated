package Entities;

public class Flight {
    private int flightId;
    private String destination;
    private String date;
    private String time;
    private int availableSeats;

    public Flight(int flightId, String destination, String date, String time, int availableSeats) {
        this.flightId = flightId;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.availableSeats = availableSeats;
    }

    public int getFlightId() {
        return flightId;
    }
    public String flightInfo() {
        return "Flight " + flightId + " - Destination: " + destination +
                ", Date: " + date + ", Time: " + time +
                ", Available Seats: " + availableSeats;
    }
    public String getDestination() {
        return this.destination;
    }

    public String getDate() {
        return this.date;
    }

    public int getAvailableSeats() {
        return this.availableSeats;
    }

    public void decreaseAvailableSeats(int captured)
    {
        this.availableSeats-=captured;
    }

}
