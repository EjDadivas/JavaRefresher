package memorableQuotes;
import java.util.Random;

public class test {
  public static void main(String[] args) {
    String[] list = {"a", "b", "c"};
    Random random = new Random();
    int[] count = new int[list.length];

    while (true) {
      int index = random.nextInt(list.length);
      count[index]++;
      System.out.println(list[index] + " (" + count[index] + ")");
    }
  }
}


import java.util.HashMap;

class QuoteTracker {
    static HashMap<String, Integer> quoteCounter = new HashMap<>();

    static void incrementCounter(String quote) {
        quoteCounter.put(quote, quoteCounter.getOrDefault(quote, 0) + 1);
    }

    static void printQuote(String quote) {
        System.out.println(quote);
        incrementCounter(quote);
        System.out.println("This quote has been displayed " + quoteCounter.get(quote) + " times");
    }
}