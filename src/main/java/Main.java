import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        File file = new File("text.txt");

        Parser parser = new Parser();
        Map<String, Integer> frequencies;

        try {
            frequencies = parser.parse(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }

        List<String> keys = new ArrayList<>();
        keys.add("страдание");
        keys.add("страдания");
        keys.add("страданию");
        keys.add("страдание");
        keys.add("страданием");
        keys.add("страдании");

        int total = 0;
        for (String key: keys) {
            total += frequencies.getOrDefault(key, 0);
        }

        System.out.println("The number of occurrences of the word \"страдание\": " + total);
    }
}
