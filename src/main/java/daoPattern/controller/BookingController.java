package daoPattern.controller;

import all.Login;
import daoPattern.dao.BookingCollection;
import daoPattern.dao.FlightCollection;
import daoPattern.model.Booking;
import daoPattern.service.BookingService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class BookingController {
    BookingService bookingService = new BookingService();
    Booking booking = new Booking();
    static BookingCollection bookingCollection = new BookingCollection();
    FlightCollection flightCollection = new FlightCollection();
    static Login login = new Login();
    Map<StringBuilder, StringBuilder> passengers = new HashMap<StringBuilder, StringBuilder>();
    StringBuilder sb = new StringBuilder();
    StringBuilder names = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    public void searchAndBook() throws IOException {

        flightCollection.getAll();


        System.out.println("Please enter destination city:");
        String destinationPoint = sc.nextLine();

        System.out.println("Please enter flight date:");
        String date = sc.nextLine();

        System.out.println("Please enter number of people (how many tickets to buy):");
        int tickets = sc.nextInt();
        //  System.out.println(FlightCollection.flightsFromDB);
        for (int i = 0; i < 31; i++) {

            if (flightCollection.flightsFromDB.get(i).contains(destinationPoint) && flightCollection.flightsFromDB.get(i).contains(date)) {
                System.out.println(flightCollection.flightsFromDB.get(i));


                System.out.println("Select flight ID from above for booking:");
                int bookID = sc.nextInt();

                for (Map.Entry<String, Integer> entry : flightCollection.flightsWithSeats.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();

                    if (key.contains(valueOf(bookID))) {

                        bookingCollection.flightSeatsAfterBook.remove(key);
                        value -= tickets;
                        bookingCollection.flightSeatsAfterBook.put(key, value);
                        sb.append(key);
                        sb.append(", ");
                        sb.append(value);
                        sb.append("\n");


                        for (int j = 0; j < tickets; j++) {
                            String fullName = sc.nextLine();
                            System.out.println("Please, enter passenger name and surname:");
                            names.append(login.usernames.get(0));
                            names.append(", ");
                            names.append(fullName);
                            passengers.put(names, sb);
                        }
                        String fullName = sc.nextLine();
                        names.append(login.usernames.get(0));
                        names.append(", ");
                        names.append(fullName);
                        passengers.put(names, sb);
                        String fileName = "booksList.txt";
                        File file = new File(fileName);
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        writer.write(String.valueOf(passengers));
                        writer.close();
                    }
                    System.out.println(key + value);
                }
                String fileName = "book.txt";
                File file = new File(fileName);
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(String.valueOf(FlightCollection.flightsWithSeats));
                writer.close();
            }
        }
    }
    public static void viewMyFlights() throws IOException {
        bookingCollection.getBookedFlights();
        System.out.println("Input passenger name for finding flight:");
        String passenger = sc.nextLine();
        for (int i=0; i<bookingCollection.bookedFlights.size(); i++) {
            if (bookingCollection.bookedFlights.get(i).contains(login.usernames.get(0)) && bookingCollection.bookedFlights.get(i).contains(passenger)) {
                String[] myFlight = bookingCollection.bookedFlights.get(i).split("=", 2);
                for (int j=1; j<myFlight.length; j++) {
                    if (j % 2 == 1) {
                        System.out.println(myFlight[j]);
                    }
                }
            }
        }
    }
}
