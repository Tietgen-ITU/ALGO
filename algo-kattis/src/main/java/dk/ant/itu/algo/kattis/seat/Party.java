package dk.ant.itu.algo.kattis.seat;

public class Party implements Comparable<Party> {
    
    private int allocatedSeats;
    private int votes;

    private double quotient;

    public Party(int votes) {

        allocatedSeats = 0;
        this.votes = votes;

        calculateQuotient();
    }

    public void allocateSeat() {

        this.allocatedSeats++;
        calculateQuotient();
    }

    public int getAllocatedSeats() {

        return this.allocatedSeats;
    }

    public double getQuotient() {

        return this.quotient;
    }

    private void calculateQuotient() {

        quotient = (double)votes / (double)(allocatedSeats + 1);
    }

    @Override
    public int compareTo(Party o) {
        
        if(this.getQuotient() > o.getQuotient()) 
            return 1;
        else if(this.getQuotient() < o.getQuotient())
            return -1;
        else
            return 0;
    }
}
