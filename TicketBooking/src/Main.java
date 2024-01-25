import Entities.Booking;
import Entities.Flight;
import Entities.Flights;
import Entities.Passenger;
import Helper.Helper;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Flights flights= new Flights();
        Flight flight1=new Flight(1010,"Moscow","10 April","10:00",3);
        Flight flight2 = new Flight(2020, "Paris", "11 April", "12:30", 5);
        Flight flight3 = new Flight(3030, "New York", "12 April", "15:45", 8);
        Flight flight4 =new Flight(4040, "Tokyo", "13 April", "18:15", 2);
        Flight flight5 =new Flight(5050, "London", "14 April", "20:30", 7)         ;
        flights.addFlight(flight1);
        flights.addFlight(flight2);
        flights.addFlight(flight3);
        flights.addFlight(flight4);
        flights.addFlight(flight5);

        Booking mybooking=new Booking();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            MainMenu();

            String choice = scanner.nextLine();
            scanner.nextLine();

            int input = Helper.tryParseInt(choice);

            switch (input) {
                case 1:
                    System.out.println("flights from Kiev in the next 24 hours:");
                    flights.displayFlights();
                    break;

                case 2:


                    int FlightID;
                    while (true) {
                        System.out.println("Enter the flight ID: ");
                        String newid = scanner.nextLine();

                        FlightID = Helper.tryParseInt(newid);
                        if (FlightID != 0) {
                            break;
                        } else {
                            System.out.println("Please enter a valid integer for ID.");
                        }
                    }
                    scanner.nextLine();
                    boolean c=false;
                    for (Flight flight : flights.getFlights()) {
                        if (flight.getFlightId() == FlightID) {
                            c=true;
                            System.out.println("Flight information: ");
                            System.out.println(flight.flightInfo());
                            break;
                        }

                    }
                    if (!c)
                    {
                        System.out.println("Flight not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the destination: ");
                    String destination = scanner.nextLine();
                    System.out.println("Enter the date: ");
                    String date = scanner.nextLine();


                    int number;

                    while (true) {
                        System.out.println("Enter the number of passengers: ");
                        String newnum = scanner.nextLine();

                        number = Helper.tryParseInt(newnum);
                        if (number != 0) {
                            break;
                        } else {
                            System.out.println("Please enter a valid integer for passengers.");
                        }
                    }
                    scanner.nextLine();
                    int i = 1;
                    Flights availableFlights = new Flights();
                    for (Flight flight : flights.getFlights()) {
                        if (Objects.equals(flight.getDestination(), destination) && Objects.equals(flight.getDate(), date) && flight.getAvailableSeats() >= number) {
                            System.out.println("Flight #" + i);
                            i++;
                            System.out.println(flight.flightInfo());
                            availableFlights.addFlight(flight);


                        }
                    }

                    System.out.println("Number of available flights: " + availableFlights.size());
                    if (availableFlights.size() >= 1) {



                        System.out.println("Choose a flight from the list above(enter serial number): ");
                        int serial = scanner.nextInt();
                        scanner.nextLine();
                        if (serial==0)
                        {
                            break;
                        }
                        int check = 0;

                        for (Flight flight : availableFlights.getFlights()) {
                            if (flight.getFlightId() == serial) {
                                check = 1;
                                System.out.println("Flight is chosed.");

                                System.out.println("Enter your full name(for booking): ");
                                String name=scanner.nextLine();
                                ArrayList<Passenger> passengers=new ArrayList<>();
                                Passenger p=new Passenger();
                                for (int j=1; j<number+1;j++)
                                {

                                    System.out.println("Enter the name of passenger "+j);
                                    String n=scanner.nextLine();
                                    p.setfirstName(n);
                                    System.out.println("Enter the surname of passenger "+j);
                                    String surname=scanner.nextLine();
                                    p.setlastName(surname);
                                    passengers.add(p);

                                }

                                mybooking.addBooking(serial,name,passengers);
                                flight.decreaseAvailableSeats(number);
                                break;
                            }

                        }
                        if (check == 0) {
                            System.out.println("Flight not found.");
                        }
                    }
                    else {
                        System.out.println("No available flights found.");
                    }
                    break;

                case 4:
                    ArrayList<Booking> bookings = Booking.getAllBookings();
                    boolean bookingCanceled = false;


                    int bookingID;

                    while (true) {
                        System.out.println("Enter booking ID: ");
                        String newwid = scanner.nextLine();

                        bookingID = Helper.tryParseInt(newwid);
                        if (bookingID != 0) {
                            break;
                        } else {
                            System.out.println("Please enter a valid integer for ID.");
                        }
                    }

                    scanner.nextLine();
                    for (Booking book: bookings)
                    {
                        if (book.getBookingId()==bookingID)
                        {
                            bookings.remove(book);
                            bookingCanceled = true;
                            break;

                        }
                    }
                    if (bookingCanceled) {
                        System.out.println("Booking with ID " + bookingID + " has been canceled.");
                    } else {
                        System.out.println("Booking not found or could not be canceled.");
                    }

                    break;
                case 5:
                    System.out.println("Enter your full name: ");
                    String userFullName = scanner.nextLine();

                    ArrayList<Booking> userBookings = Booking.getBookingsByFullName(userFullName);

                    if (!userBookings.isEmpty()) {
                        System.out.println("Your bookings:");
                        for (Booking booking : userBookings) {
                            System.out.println(booking.BookingInfo());
                        }
                    } else {
                        System.out.println("No bookings found for " + userFullName);
                    }

                    break;
                case 6:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void MainMenu()
    {
        System.out.println("Welcome to main menu:");
        System.out.println("1. Online board");
        System.out.println("2. Show the flight info");
        System.out.println("3. Search and book a flight");
        System.out.println("4. Cancel the booking");
        System.out.println("5. My flights");
        System.out.println("6. Exit");
    }

}
