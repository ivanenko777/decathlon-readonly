import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    // QUESTION: ar path saugoti kaip lauka?
    private String path;
    private List<String[]> fileData;

    public FileReader(String path) {
        this.path = path;
    }

    public List<String[]> getFileData() {
        return fileData;
    }

    public void readFile() {
        List<String[]> result = new ArrayList<>();
        try {
            File file = new File(this.path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().trim().split(";");
                result.add(line);
                System.out.println(Arrays.toString(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: FileReader");
            e.printStackTrace();
        }
        this.fileData = result;
    }
}
