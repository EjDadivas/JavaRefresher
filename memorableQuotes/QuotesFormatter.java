package memorableQuotes;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.FileWriter;

public class QuotesFormatter {
        // for the quotes counter
        static Map<String, Integer> count = new HashMap<>();

        public String formattedQuotes(String quote, String author, String category, int count){
                String format = quote+"@"+author+"@"+category+"@"+count;
                return(format);
        }

        public void incrementCount(String quote) {
                if (!count.containsKey(quote)) {
                    count.put(quote, 0);
                }
                count.put(quote, count.get(quote) + 1);
                System.out.println(count.get(quote));

            }


        }

        
        

