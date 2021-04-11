package dk.ant.itu.algo.kattis.flight;

import java.util.concurrent.TimeUnit;

public class TimeStamp implements Comparable<TimeStamp> { 
    
    private int seconds = 0;
    private final int MAX_SECONDS = 86399;

    public TimeStamp(String time) {
        String[] timeParts = time.split(":");
        int seconds = 0;

        seconds += TimeUnit.HOURS.toSeconds(Long.parseLong(timeParts[0]));
        seconds += TimeUnit.MINUTES.toSeconds(Long.parseLong(timeParts[1]));
        seconds += Integer.parseInt(timeParts[2]);

        this.seconds = seconds > MAX_SECONDS ? MAX_SECONDS : seconds;
    }

    private TimeStamp(int seconds) {

        this.seconds = seconds > MAX_SECONDS ? MAX_SECONDS : seconds;
    }

    public TimeStamp delay(int seconds) {
        
        TimeStamp delayed = new TimeStamp(this.seconds + seconds);

        return delayed;
    }

    public int getTimeInSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        
        int seconds = this.seconds;
        long hours = TimeUnit.SECONDS.toHours(this.seconds);
        seconds -= TimeUnit.HOURS.toSeconds(hours);
        long minutes = TimeUnit.SECONDS.toMinutes(seconds);
        seconds -= TimeUnit.MINUTES.toSeconds(minutes);

        StringBuilder builder = new StringBuilder();
        builder.append(hours);
        builder.append(":");
        builder.append(minutes);
        builder.append(":");
        builder.append(seconds);

        
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    @Override
    public int compareTo(TimeStamp o) {
        
        if(this.seconds > o.getTimeInSeconds()) return 1;
        else if(this.seconds < o.getTimeInSeconds()) return -1;
        else return 0;
    }
}
