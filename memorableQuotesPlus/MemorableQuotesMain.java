package memorableQuotesPlus;

import java.util.ArrayList;
import java.util.Scanner;

public class MemorableQuotesMain {

    public static void main(String[] args) {
        MemorableQuotesDatabase quotesList = new MemorableQuotesDatabase();
        MemorableQuotesDisplayShow displayQuotesList = new MemorableQuotesDisplayShow(quotesList);
        String filename = "C:\\Users\\CL-1\\Desktop\\JavaRefresher\\JavaRefresher\\memorableQuotesPlus\\quotes.txt";

        System.out.println(quotesList);
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose: [all/random/search]");
            String parameter = sc.nextLine();

            // add remove
            // MemorableQuote test1 = new MemorableQuote("test 2");
            // quotesList.addQuote(test1);
            // quotesList.removeQuote(test1);

            // quote by index
            MemorableQuote x = quotesList.getQuoteByIndex(1);
            // x.printQuote();
            quotesList.writeToFile(filename);

            // quote count
            // System.out.println(quotesList.getQuoteCount());

            if (quotesList.getQuoteCount() != 0) {
                // ALL
                if ("all".equals(parameter)) {
                    // print all
                    for (MemorableQuote i : quotesList.getAllQuotes()) {
                        i.printQuote();
                        quotesList.writeToFile(filename);
                        quotesList.writeToFile(filename);
                    }
                } else if (parameter.startsWith("all category=")) {
                    String name = parameter.substring("all category=".length());
                    // do the search here
                    ArrayList<MemorableQuote> categoryList = quotesList.searchCategory(name);

                    categoryList.retainAll(quotesList.getAllQuotes());

                    for (MemorableQuote i : categoryList) {
                        i.printQuote();
                        quotesList.writeToFile(filename);
                        quotesList.writeToFile(filename);
                    }
                    // RANDOM
                } else if ("random".equals(parameter)) {
                    // random
                    MemorableQuote random = quotesList.getRandomQuote();
                    random.printQuote();
                    quotesList.writeToFile(filename);

                } else if (parameter.startsWith("random category=")) {
                    String name = parameter.substring("random category=".length());
                    // do the search here
                    MemorableQuote randomCat = quotesList.randomCategory(name);
                    randomCat.printQuote();
                    quotesList.writeToFile(filename);

                    // SEARCH
                } else if (parameter.startsWith("search ")) {
                    String search = "";
                    ArrayList<MemorableQuote> searchedCategory = null;
                    String name = parameter.substring("search ".length());
                    String[] split = name.split(" ");
                    if (split.length == 2) {
                        for (String i : split) {
                            if (i.contains("=")) {
                                String[] splitCommand = i.split("=");
                                if ("category".equals(splitCommand[0])) {
                                    // for the category search
                                    searchedCategory = quotesList.searchCategory(splitCommand[1]);
                                } else {
                                    System.out.println("try using category=<category_name>");
                                }
                            } else {
                                search = i;
                            }
                        }
                        searchedCategory.retainAll(quotesList.searchQuotes(search));
                        for (MemorableQuote item : searchedCategory) {
                            item.printQuote();
                            quotesList.writeToFile(filename);
                        }
                    } else {
                        for (MemorableQuote item : quotesList.searchQuotes(name)) {
                            item.printQuote();
                            quotesList.writeToFile(filename);
                        }
                    }

                    // DISPLAY
                } else if ("display".equals(parameter)) {
                    displayQuotesList.execute();
                } else if (parameter.startsWith("display ")) {
                    String name = parameter.substring("display ".length());
                    String[] split = name.split(" ");
                    for (String i : split) {
                        String[] splitCommand = i.split("=");
                        if ("delay".equals(splitCommand[0])) {
                            displayQuotesList.setDelayBetweenQuotes(Integer.parseInt(splitCommand[1]));
                        } else if ("max".equals(splitCommand[0])) {
                            displayQuotesList.setMaxQuotesToDisplay(Integer.parseInt(splitCommand[1]));
                        } else if ("category".equals(splitCommand[0])) {
                            displayQuotesList.setCategory(splitCommand[1]);
                        }
                    }
                    displayQuotesList.execute();

                } else if ("delete".equals(parameter)) {
                    System.out.println("Enter the index u want to delete");
                    int index = sc.nextInt();
                    quotesList.removeQuote(quotesList.getQuoteByIndex(index - 1));

                } else if ("quit".equals(parameter)) {
                    break;
                } else {
                    System.out.println("Invalid command");
                }

            } else {
                System.out.println("Error, No Quotes available");
                break;
            }
        }
        // end if statement

    }
}