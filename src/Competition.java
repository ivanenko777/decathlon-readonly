import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Competition {
    private List<String[]> fileData;
    private List<Athlete> athletes;
    private HashMap<Integer, Integer> scoresCount;

    public Competition(List<String[]> fileData) {
        this.fileData = fileData;
        this.athletes = new ArrayList<>();
        this.scoresCount = new HashMap<>();
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

            // count scores: 1244 -> 1 , 2588 -> 2
            int totalScore = athlete.getTotalScore();
            this.scoresCount.putIfAbsent(totalScore, 0);
            int count = scoresCount.get(totalScore) + 1;
            this.scoresCount.put(totalScore, count);
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
        String displayRank = "";
        for (Athlete athlete : athletes) {
            rank++;
            int scoreCount = this.scoresCount.get(athlete.getTotalScore());
            if (athlete.getTotalScore() < lastScore) {
                displayRank = scoreCount == 1 ? String.valueOf(rank) : String.format("%d-%d", rank, rank + scoreCount - 1);
            }
            athlete.setPlace(displayRank);
            lastScore = athlete.getTotalScore();
        }
    }
}
