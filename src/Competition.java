import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Competition {
    private List<String[]> fileData;
    private List<Athlete> athletes;

    public Competition(List<String[]> fileData) {
        this.fileData = fileData;
        this.athletes = new ArrayList<>();
    }

    public List<Athlete> getAthletes() {
        return athletes;
    }

    public void createAthletes() {
        for (String[] item : fileData) {
            Athlete athlete = new Athlete(item);
            athletes.add(athlete);
        }
    }

    public void calcTotalScores() {
        for (Athlete athlete : this.athletes) {
            athlete.calcTotalScore();
        }
    }

    public void sortAthletesByTotalScores() {
        // Comparator
        // https://stackoverflow.com/questions/12449766/java-sorting-sort-an-array-of-objects-by-property-object-not-allowed-to-use-co
        // https://stackoverflow.com/questions/2839137/how-to-use-comparator-in-java-to-sort
//        this.athletes.sort((o1, o2) -> Integer.compare(o2.getTotalScore(), o1.getTotalScore()));

        this.athletes.sort(new Comparator<Athlete>() {
            @Override
            public int compare(Athlete o1, Athlete o2) {
                return Integer.compare(o2.getTotalScore(), o1.getTotalScore());
            }
        });
    }

    public void assignPlaces() {
//        https://stackoverflow.com/questions/55204613/rank-students-based-on-score
        int lastScore = Integer.MAX_VALUE;
        int rank = 0;
        int displayRank = rank;
        for (Athlete athlete : athletes) {
            rank++;
            if (athlete.getTotalScore() < lastScore) {
                displayRank = rank;
            }
            athlete.setPlace(String.valueOf(displayRank));
            lastScore = athlete.getTotalScore();
        }
    }
}
