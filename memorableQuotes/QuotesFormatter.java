package memorableQuotes;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class QuotesFormatter {
        // for the quotes counter
        static Map<String, Integer> count = new HashMap<>();
        private static final String FILE_NAME = "C:\\Users\\CL-1\\Desktop\\JavaRefresher\\JavaRefresher\\memorableQuotes\\quotes.txt";

        public String formattedQuotes(String quote, String author, String category, int count){
                String format = quote+"@"+author+"@"+category+"@"+count;
                return(format);
        }

        public int incrementCount(String quote) {
                if (!count.containsKey(quote)) {
                    count.put(quote, 0);
                }
                count.put(quote, count.get(quote) + 1);
                int counter = count.get(quote);
                return(counter);
        }   
        
        private void updateCountInFile(String quote, int newCount) {
                try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                    String line;
                    StringBuilder sb = new StringBuilder();
                    boolean quoteFound = false;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split("@");
                        if (parts[0].equals(quote)) {
                            sb.append(quote + "@" + parts[1] + "@" + parts[2] + "@" + newCount + "\n");
                            quoteFound = true;
                        } else {
                            sb.append(line + "\n");
                        }
                    }
                    if (!quoteFound) {
                        sb.append(quote + "@" + "Unknown" + "@" + "Unknown" + "@" + newCount + "\n");
                    }
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                        writer.write(sb.toString());
                    }
                } catch (IOException e) {
                    System.out.println("Error reading/writing the quotes file: " + e.getMessage());
                }
            }
        }


        
        

