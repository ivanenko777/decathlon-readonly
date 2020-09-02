import java.util.List;

public class DecathlonRunner {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\mail\\OneDrive\\Desktop\\VCS_JAVA&ANDROID\\code_decathlon\\Decathlon_input.txt";
        String outputPath = "C:\\Users\\mail\\OneDrive\\Desktop\\VCS_JAVA&ANDROID\\code_decathlon\\Decathlon_output.xml";

        FileReader fileReader = new FileReader(inputPath);
        fileReader.readFile();
        List<String[]> fileData = fileReader.getFileData();

        Competition competition = new Competition(fileData);
        competition.createAthletes();
        competition.calcTotalScores();
        competition.sortAthletesByTotalScores();
        competition.assingPlaces();

        GenerateXml xml = new GenerateXml(competition.getAthletes(), outputPath);
        xml.generate();
        xml.prettySave();
    }
}
