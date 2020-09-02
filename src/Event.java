public class Event {
    private EventConstants eventConstants;
    private int score;
    private float performance;

    public Event(EventConstants eventConstants, String performance) {
        this.eventConstants = eventConstants;
        this.performance = Float.parseFloat(performance);
    }

    public EventConstants getEventConstants() {
        return eventConstants;
    }

    public int getScore() {
        return score;
    }

    public float getPerformance() {
        return performance;
    }

    public void calcScore() {
        float a = eventConstants.getA();
        float b = eventConstants.getB();
        float c = eventConstants.getC();
        float p = this.performance;
        this.score = (int) Math.floor(a * Math.pow(Math.abs(b - p), c));
    }
}
