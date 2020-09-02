import java.util.ArrayList;
import java.util.List;

public class Athlete {
    private String fullName;
    private String place;
    private int totalScore;
    private List<Event> events = new ArrayList<>();

    public Athlete(String[] data) {
        createAthlete(data);
    }

    public String getFullName() {
        return fullName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public List<Event> getEvents() {
        return events;
    }

    private void createAthlete(String[] data) {
        this.fullName = data[0];
        events.add(new Event(EventConstants.FIRST_EVENT, data[1]));
        events.add(new Event(EventConstants.SECOND_EVENT, data[2]));
        events.add(new Event(EventConstants.THIRD_EVENT, data[3]));
        events.add(new Event(EventConstants.FOUTRH_EVENT, data[4]));
        events.add(new Event(EventConstants.FIFTH_EVENT, data[5]));
        events.add(new Event(EventConstants.SIXTH_EVENT, data[6]));
        events.add(new Event(EventConstants.SEVENTH_EVENT, data[7]));
        events.add(new Event(EventConstants.EIGHTH_EVENT, data[8]));
        events.add(new Event(EventConstants.NINTH_EVENT, data[9]));
        events.add(new Event(EventConstants.TENTH_EVENT, Helper.convertValueToSeconds(data[10])));
    }

    public void calcTotalScore() {
        int sum = 0;
        for (Event event : events) {
            event.calcScore();
            sum += event.getScore();
        }
        this.totalScore = sum;
    }

}
