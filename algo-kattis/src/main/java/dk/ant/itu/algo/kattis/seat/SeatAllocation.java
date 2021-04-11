package dk.ant.itu.algo.kattis.seat;

import java.util.Scanner;

import edu.princeton.cs.algs4.MaxPQ;

public class SeatAllocation {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int parties = scanner.nextInt();
        int seats = scanner.nextInt();

        MaxPQ<Party> pq = new MaxPQ<>(parties);
        Party[] p = new Party[parties];

        // Create parties
        for(int i = 0; i < parties; i++) {

            scanner.nextLine();
            int votes = scanner.nextInt();
            Party party = new Party(votes);
            pq.insert(party);
            p[i] = party;
        }

        // Allocate seats
        for(int i = 0; i < seats; i++) {

            Party currentParty = pq.delMax();
            currentParty.allocateSeat();
            pq.insert(currentParty);
        }

        for (Party party : p) {
            
            System.out.println(party.getAllocatedSeats());
        }
    }
    
}
