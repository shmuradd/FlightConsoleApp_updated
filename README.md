# Flight Booking Console

A Java console project that explores flight search, passenger records, booking creation, and booking lookup through a menu-driven interface.

## Menu functions

- Display sample flights and look up flight information.
- Search by destination, date, and passenger count.
- Create a booking and reduce the selected flight's available seats.
- Cancel a booking or find bookings by a passenger's name.

## Design

| Class | Responsibility |
| --- | --- |
| `Main` | Sample flight setup and the interactive menu |
| `Flight` / `Flights` | Flight records and the flight collection |
| `Booking` | In-memory booking records and lookups |
| `Passenger` | Passenger details |
| `Helper` | Input-parsing utilities |

The source is inside [`TicketBooking/src`](TicketBooking/src). Flights are seeded in `Main`, and bookings are held in memory for the current process; there is no database or live airline integration.

## Getting started

Open `TicketBooking/src` as a Java source root in an IDE and run `Main` with a Java Development Kit.

The project demonstrates Java classes, collections, and console input using a small set of sample flights.
