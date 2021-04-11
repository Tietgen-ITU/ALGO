package dk.ant.itu.algo.kattis.flight;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import edu.princeton.cs.algs4.RedBlackBST;

/**
 * This class is for the Kattis task 'Flight' from my course in algorithms and data structures
 * @author Andreas Nicolaj Tietgen
 */
public class Flight {
    
    private static RedBlackBST<TimeStamp, String> plannedFlights;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        plannedFlights = new RedBlackBST<>();

        int n = sc.nextInt(); // Amount of starting planned flights
        int m = sc.nextInt(); // Amount of operations to execute on the list of planned flights
        sc.nextLine();

        // Insert planned flights
        for(int i = 0; i < n; i++) {
            String[] flight = sc.nextLine().split(" ");

            plannedFlights.put(new TimeStamp(flight[0]), flight[1]);
        }

        // Execute operations
        for(int i = 0; i < m; i++) {
            String[] instruction = sc.nextLine().split(" ");

            switch (instruction[0]) {
                case "destination":
                        destination(instruction[1]);
                    break;
                case "cancel":
                        cancel(instruction[1]);
                    break;
                case "delay":
                    delay(instruction[1], instruction[2]);
                    break;
                case "reroute":
                    reroute(instruction[1], instruction[2]);
                    break;
                case "next":
                    next(instruction[1]);
                    break;
                case "count":
                    count(instruction[1], instruction[2]);
                    break;
                default:
                    throw new RuntimeException("Operation not supported: " + instruction[0]);
            }
        }
    }

    private static void delay(String key, String secondsToDelay) {
        int seconds = Integer.parseInt(secondsToDelay);
        TimeStamp time = new TimeStamp(key);
        
        String destination = plannedFlights.get(time);              // Get value from key
        plannedFlights.delete(time);                                // Remove the old one because keys are supposed to be immutable
        plannedFlights.put(time.delay(seconds), destination);       // Add it again with the new key
    }

    private static void reroute(String key, String newDestination) {
        
        plannedFlights.put(new TimeStamp(key), newDestination);
    }

    private static void destination(String key) {
        
        String destination = plannedFlights.get(new TimeStamp(key));

        if(destination != null)
            System.out.println(destination);
        else
            System.out.println("-");
    }

    private static void cancel(String key) {
        plannedFlights.delete(new TimeStamp(key));
    }

    private static void next(String key) {
        
        TimeStamp time = new TimeStamp(key);
        TimeStamp correctKey = plannedFlights.ceiling(time);
        String destination = plannedFlights.get(correctKey);
        
        StringBuilder builder = new StringBuilder();
        builder.append(correctKey);
        builder.append(" ");
        builder.append(destination);

        System.out.println(builder.toString());
    }

    private static void count(String from, String to) {

        System.out.println(plannedFlights.size(new TimeStamp(from), new TimeStamp(to)));
    }

    private static LocalTime convertToTime(String time) {
        String[] timeParts = time.split(":");

        return LocalTime.of(Integer.parseInt(timeParts[0]), Integer.parseInt(timeParts[1]), Integer.parseInt(timeParts[2]));
    }
}
