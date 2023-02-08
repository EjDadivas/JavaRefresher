package memorableQuotesPlus;

import java.util.HashMap;
import java.util.Map;

public class MemorableQuote {
    // for the counter
    private static Map<String, Integer> count = new HashMap<>();
    private String quoteText;
    private String reference;
    private int counter = 0;
    private String newLine = "";

    public String getNewLine() {
        return newLine;
    }

    public void setNewLine(String newLine) {
        this.newLine = newLine;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    private String category;

    // constructors
    MemorableQuote(String quoteText, String reference, String category, int counter) {
        this.quoteText = quoteText;
        this.reference = reference;
        this.category = category;
        this.counter = counter;
    }

    // Setters
    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Getters
    public String getQuoteText() {
        return quoteText;
    }

    public String getReference() {
        return reference;
    }

    public String getCategory() {
        return category;
    }

    public void printQuote() {
        counter++;
        // if (!count.containsKey(quoteText)) {
        // count.put(quoteText, getCounter());
        // }
        // count.put(quoteText, count.get(quoteText) + 1);
        // counter = count.get(quoteText);
        System.out.println(quoteText + " (" + counter + ")" + "\n -- " + reference + "|" + category + "\n");

    }

    public boolean matches(String text) {
        if (quoteText.toLowerCase().contains(text.toLowerCase())
                || reference.toLowerCase().contains(text.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchedCat(String text) {
        if (category.toLowerCase().equals(text.toLowerCase())) {
            return true;
        } else {
            return false;

        }
    }

}
