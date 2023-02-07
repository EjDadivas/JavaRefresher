package memorableQuotesPlus;

public class MemorableQuotesDisplayShow {
    
    MemorableQuotesDatabase memorableQuotesDb;
    private int delayBetweenQuotes = 3;
    private int maxQuotesToDisplay = 0 ;

    MemorableQuotesDisplayShow(MemorableQuotesDatabase memorableQuotesDb){
        this.memorableQuotesDb = memorableQuotesDb;
    }
    public int getDelayBetweenQuotes() {
        return delayBetweenQuotes * 1000;
    }
    public void setDelayBetweenQuotes(int delayBetweenQuotes) {
        this.delayBetweenQuotes = delayBetweenQuotes;
    }
    public int getMaxQuotesToDisplay() {
        return maxQuotesToDisplay;
    }
    public void setMaxQuotesToDisplay(int maxQuotesToDisplay) {
        this.maxQuotesToDisplay = maxQuotesToDisplay;
    }
    public void execute(){
        int displayCount = 0;
        while (maxQuotesToDisplay <= 0 || displayCount < maxQuotesToDisplay) {
            MemorableQuote random = memorableQuotesDb.getRandomQuote();
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
