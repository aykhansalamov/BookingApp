package all;

import daoPattern.controller.BookingController;
import daoPattern.controller.FlightController;
import daoPattern.dao.BookingCollection;
import daoPattern.dao.FlightCollection;

import java.io.IOException;
import java.util.Scanner;

public class Start {
    public static void start() throws IOException {

        FlightController flightController = new FlightController();
        FlightCollection flightCollection = new FlightCollection();
        BookingController bookingController = new BookingController();
        BookingCollection bookingCollection = new BookingCollection();
        Scanner sc = new Scanner(System.in);
        System.out.println("==BOOKING APP==");
        System.out.println("Choose the number of action below for continue app:");
        System.out.println("1 - Online board");
        System.out.println("2 - Show the flight info");
        System.out.println("3 - Search and book a flight");
        System.out.println("4 - Cancel the booking");
        System.out.println("5 - My flights");
        System.out.println("6 - Exit");
       // flightCollection.flightSeatsMap();
       // bookingCollection.flightSeatsAfterBooking();
        // flightController.createFlights();
        // System.out.println(flightCollection.flightSeatsMap());
        //  System.out.println(flightCollection.flightsWithSeats);
bookingController.viewMyFlights();
        // System.out.println(flightCollection.getAll()); // show all flights
        // flightController.showFlightInfo(); // show single flight info by ID
       // bookingController.searchAndBook(); // search and book a flight
        // flightController.createFlights();
        // flightController.createFlights();

        // System.out.println(flightCollection.destinationCity);

    }
}
