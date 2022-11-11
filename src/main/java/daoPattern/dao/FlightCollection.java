package daoPattern.dao;

import enums.City;
import enums.Country;

import java.io.*;
import java.util.*;

import static enums.City.*;
import static enums.Country.*;

public class FlightCollection implements FlightDao {

    public Map<City, Country> to = new HashMap<>();
    public List<Object> destinationCity = new ArrayList<>();
    public static ArrayList<String> flightsFromDB = new ArrayList<>();
    static ArrayList<String> singleFlight = new ArrayList<>();
    public static Map<String, Integer> flightsWithSeats = new HashMap<>();

    public List<Object> destination() {
        to.put(BAKU, AZERBAIJAN);
        to.put(VIENNA, AUSTRIA);
        to.put(BRUSSELS, BELGIUM);
        to.put(TORONTO, CANADA);
        to.put(PULA, CROATIA);
        to.put(SPLIT, CROATIA);
        to.put(LARNACA, CYPRUS);
        to.put(PRAGUE, CZECHIA);
        to.put(COPANHAGEN, DENMARK);
        to.put(CAIRO, EGYPT);
        to.put(PARIS, FRANCE);
        to.put(TBILISI, GEORGIA);
        to.put(DUSSELDORF, GERMANY);
        to.put(MUNICH, GERMANY);
        to.put(ATHENS, GREECE);
        to.put(BUDAPEST, HUNGARY);
        to.put(NEW_DELHI, INDIA);
        to.put(TEL_AVIV, ISRAEL);
        to.put(ROME, ITALY);
        to.put(MILAN, ITALY);
        to.put(TIVAT, MONTENEGRO);
        to.put(AMSTERDAM, NETHERLAND);
        to.put(OSLO, NORWAY);
        to.put(WARSAW, POLAND);
        to.put(BARCELONA, SPAIN);
        to.put(MADRID, SPAIN);
        to.put(STOCKOLM, SWEDEN);
        to.put(GENEVA, SWITZERLAND);
        to.put(ZURICH, SWITZERLAND);
        to.put(LONDON, UK);
        to.put(ISTANBUL, TURKIYE);

        for (
                Map.Entry<City, Country> entry : to.entrySet()) {

            City key = entry.getKey();
            Country value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(key);
            sb.append(" - ");
            sb.append(value);
            destinationCity.add(sb);
        }
        return destinationCity;

    }

    public static ArrayList<String> getAll() throws IOException {

        String fileName = "flightsList.txt";
        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;


            while ((line = br.readLine()) != null) {

                flightsFromDB.add(line);

            }
            return flightsFromDB;
        }
    }

    public static void showAllFlights() throws IOException {

        String fileName = "flightsList.txt";
        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;


            while ((line = br.readLine()) != null) {

                System.out.println(line);
            }
        }
    }

        public static Map<String, Integer> flightSeatsMap() throws IOException {
        getAll();
            for (int i=0; i<31; i++) {
              flightsWithSeats.put(flightsFromDB.get(i).substring(0, flightsFromDB.get(i).length()-3), Integer.valueOf(flightsFromDB.get(i).substring(flightsFromDB.get(i).length()-3, flightsFromDB.get(i).length()-1+1)));
            }
            return flightsWithSeats;
        }

//    static FlightService flightService = new FlightService();
//    public static Map<Integer, String> flightsFromDB;
//
//    public static void putFlightIdToToDB() throws IOException {
//
//        String fileName = "flightidto.txt";
//        File file = new File(fileName);
//        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//        writer.write(valueOf(flightService.createFlightsIdTo()));
//        writer.close();
//    }
//
//    public static void putFlightIdSeatsToDB() throws IOException {
//
//        String fileName = "flightidseats.txt";
//        File file = new File(fileName);
//        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//        writer.write(valueOf(flightService.createFlightsIdSeats()));
//        writer.close();
//    }
//
//    public static Map<Integer, String> getFlightIdToFromDB() throws IOException {
//        flightsFromDB = new HashMap<>();
//        String fileName = "flightidto.txt";
//        File file = new File(fileName);
//        ArrayList<String> fl = new ArrayList<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line;
//            String str;
//
//            while ((line = br.readLine()) != null) {
//                str = line.substring(1);
//                fl.add(str);
//            }
//
//            fl.remove(31);
//            String st = fl.get(0).substring(2);
//
//            flightsFromDB.put(1, st);
//            for (int i = 1; i < 9; i++) {
//                String s = fl.get(i).substring(3);
//
//                flightsFromDB.put(i + 1, s);
//            }
//            for (int i = 9; i < fl.toArray().length; i++) {
//                String s1 = fl.get(i).substring(4);
//
//                flightsFromDB.put(i + 1, s1);
//            }
//        }
//
//
//        return flightsFromDB;
//    }
//
//    public Map<Integer, String> getFlightIdSeatsFromDB() throws IOException {
//        List<String> idSeats = new ArrayList<>();
//        Map<Integer, String> seatsMap = new HashMap<>();
//        String fileName = "flightidseats.txt";
//        File file = new File(fileName);
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line;
//            String str;
//            String s;
//            while ((line = br.readLine()) != null) {
//                str = line.substring(1);
//                s = str + "\n";
//                idSeats.add(s);
//            }
//            idSeats.remove(31);
//            seatsMap.put(Integer.valueOf(idSeats.get(0)), String.valueOf(idSeats.get(0).substring(3, 6)));
//            Integer id = 1;
//            for (int i = 1; i < 31; i++) {
//                idSeats.get(i).substring(3);
//// Integer seat = 3;
//                String seat = idSeats.get(i).substring(3, 6);
//                id++;
//                seatsMap.put(id, seat);
//            }
//
//
//            return seatsMap;
//        }
//    }



}