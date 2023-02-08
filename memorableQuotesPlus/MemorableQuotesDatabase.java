package memorableQuotesPlus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemorableQuotesDatabase {
    private ArrayList<MemorableQuote> quotes;
    private String filename = "C:\\Users\\CL-1\\Desktop\\JavaRefresher\\JavaRefresher\\memorableQuotesPlus\\quotes.txt";

    public void setQuotes(ArrayList<MemorableQuote> quotes) {
        this.quotes = quotes;
    }

    public MemorableQuotesDatabase() {

        readFromFile(filename);

    }

    public ArrayList<MemorableQuote> getQuotes() {
        return this.quotes;
    }

    public MemorableQuote getRandomQuote() {
        Random ran = new Random();
        int n = ran.nextInt(quotes.size());
        return quotes.get(n);

    }

    public void addQuote(MemorableQuote quote) {
        quotes.add(quote);
    }

    public void removeQuote(MemorableQuote quote) {
        quotes.remove(quote);
    }

    public MemorableQuote getQuoteByIndex(int n) {
        return quotes.get(n);
    }

    public ArrayList<MemorableQuote> getAllQuotes() {
        return quotes;
    }

    public int getQuoteCount() {
        return quotes.size();
    }

    public ArrayList<MemorableQuote> searchQuotes(String text) {
        ArrayList<MemorableQuote> matchedQuotes = new ArrayList<>();
        for (MemorableQuote i : quotes) {
            if (i.matches(text)) {
                System.out.println("matched");
                matchedQuotes.add(i);
            }
        }
        return (matchedQuotes);
    }

    public ArrayList<MemorableQuote> searchCategory(String text) {
        ArrayList<MemorableQuote> matchedCategory = new ArrayList<>();
        for (MemorableQuote i : quotes) {
            if (i.matchedCat(text)) {
                matchedCategory.add(i);
            }
        }
        return (matchedCategory);
    }

    public MemorableQuote randomCategory(String text) {
        Random ran = new Random();
        int n = ran.nextInt(searchCategory(text).size());

        return searchCategory(text).get(n);
    }

    public boolean readFromFile(String filename) {
        quotes = new ArrayList<>();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(filename));

            for (String line : allLines) {
                String[] split = line.split("@");
                quotes.add(new MemorableQuote(split[0], split[1], split[2], Integer.parseInt(split[3])));
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean writeToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            ArrayList<String> write = new ArrayList<>();
            for (MemorableQuote quote : quotes) {
                write.add(quote.getQuoteText() + "@" + quote.getReference() + "@" + quote.getCategory() + "@"
                        + quote.getCounter());
            }
            for (String str : write) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred while updating data in the file: " + e.getMessage());
            return false;
        }
    }
}

// index, and the line i want to update