package memorableQuotesPlus;

public class MemorableQuotesDisplayShow {

    MemorableQuotesDatabase memorableQuotesDb;
    private int delayBetweenQuotes = 3;
    private int maxQuotesToDisplay = 0;
    private String category = null;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    MemorableQuotesDisplayShow(MemorableQuotesDatabase memorableQuotesDb) {
        this.memorableQuotesDb = memorableQuotesDb;
    }

    public MemorableQuotesDatabase getMemorableQuotesDb() {
        return memorableQuotesDb;
    }

    public int getDelayBetweenQuotes() {
        return delayBetweenQuotes * 1000;
    }

    public int getMaxQuotesToDisplay() {
        return maxQuotesToDisplay;
    }

    public void setMemorableQuotesDb(MemorableQuotesDatabase memorableQuotesDb) {
        this.memorableQuotesDb = memorableQuotesDb;
    }

    public void setMaxQuotesToDisplay(int maxQuotesToDisplay) {
        this.maxQuotesToDisplay = maxQuotesToDisplay;
    }

    public void setDelayBetweenQuotes(int delayBetweenQuotes) {
        this.delayBetweenQuotes = delayBetweenQuotes;
    }

    public void execute() {
        int displayCount = 0;

        while (maxQuotesToDisplay <= 0 || displayCount < maxQuotesToDisplay) {
            MemorableQuote random;
            if (category != null) {
                random = memorableQuotesDb.randomCategory(category);
            } else {
                random = memorableQuotesDb.getRandomQuote();
            }
            random.printQuote();
            displayCount++;

            try {
                Thread.sleep(getDelayBetweenQuotes());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
