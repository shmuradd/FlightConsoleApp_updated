package Entities;

import java.util.ArrayList;

public class Booking {

    private static ArrayList<Booking> allBookings = new ArrayList<>(); // Add a static list to hold all bookings

    private int bookingID;
    private String fullName;
    private ArrayList<Passenger> passengers;

    public Booking() {
        this.passengers = new ArrayList<>();
    }
    public static ArrayList<Booking> getAllBookings() {
        return allBookings;
    }

    public int getBookingId() {
        return bookingID;
    }


    public String BookingInfo() {
        return "Booking " + bookingID + " - Passenger: " + fullName +
                ", Passengers: " + passengers.size();
    }
    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }
    public void addBooking( int bookingID, String fullName, ArrayList<Passenger> passengers) {
        this.bookingID=bookingID;
        this.fullName=fullName;
        this.passengers=passengers;
        allBookings.add(this);
    }
    public String getFullName() {
        return fullName;
    }
    public static ArrayList<Booking> getBookingsByFullName(String fullName) {
        ArrayList<Booking> userBookings = new ArrayList<>();
        for (Booking booking : allBookings) {
            if (booking.getFullName().equals(fullName)) {
                userBookings.add(booking);
            }
            else {
                for (Passenger passenger : booking.getPassengers()) {
                    if (passenger.PassengerInfo().equals(fullName)) {
                        userBookings.add(booking);
                        break; // No need to check other passengers in the same booking
                    }
                }
            }
        }
        return userBookings;
    }



    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
}
