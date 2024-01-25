package Entities;

import java.util.ArrayList;

public class Flights  {

    private ArrayList<Flight> flights;

    public Flights()
    {
        flights=new ArrayList<>();
    }
    public void addFlight(Flight flight)
    {
        flights.add(flight);
    }

    public int size()
    {
        return flights.size();
    }
    public ArrayList<Flight> getFlights() {
        return this.flights;
    }
    public void displayFlights() {
        for (Flight flight : flights) {
            System.out.println(flight.flightInfo());
        }
    }



}
