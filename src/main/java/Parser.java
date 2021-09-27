import java.io.*;
import java.util.*;

public class Parser {
    public Map<String, Integer> parse(File file) throws FileNotFoundException {
        HashMap<String, Integer> frequencies = new HashMap<>();

        String charset = "UTF-8";
        Scanner scanner = new Scanner(file, charset);

        scanner.useDelimiter("[^a-zA-Z]+");
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();

            if (frequencies.containsKey(word)) {
                int previousValue = frequencies.get(word);
                frequencies.put(word, previousValue + 1);
            } else {
                frequencies.put(word, 1);
            }
        }

        scanner.close();

        return frequencies;
    }
}
