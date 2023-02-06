package memorableQuotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QuotesFormatter {
    // for the quotes counter
    private static Map<String, Integer> count = new HashMap<>();
    // private static final String FILE_NAME = "C:\\Users\\ASUS\\Desktop\\Self-Study\\JavaRefresher\\memorableQuotes\\quotes.txt";
    private static final String FILE_NAME = "C:\\Users\\CL-1\\Desktop\\JavaRefresher\\JavaRefresher\\memorableQuotes\\quotes.txt";


    public String formattedQuotes(String quote, String author, String category, int counter) {
        String format = quote + "@" + author + "@" + category + "@" + counter;
        return (format);
    }

    public void incrementCount(String quote, int index, ArrayList<String> quotes) {
        String[] split = quote.split("@");
        String newLine = "";
        if (!count.containsKey(quote)) {
            count.put(quote, Integer.parseInt(split[3]));
        }
        count.put(quote, count.get(quote) + 1);
        int counter = count.get(quote);

        // change this format
        newLine = formattedQuotes(split[0], split[1], split[2], counter);

        try {
            List<String> allLines = Files.readAllLines(Paths.get(FILE_NAME));
            allLines.set(index, newLine);
            Files.write(Paths.get(FILE_NAME), allLines);

        } catch (IOException e) {
            System.out.println("error at " + index);
            e.printStackTrace();
        }

    }
}
