package model;

public class DigitalBook extends Book{
    private final String format;
    private final boolean freeTrial;
    private int freeTrialLength = 3;

    public DigitalBook(String title, String author, int pageNumber, String genre, int publicationYear, int stock, String format, boolean freeTrial){
        super(title, author, pageNumber, genre, publicationYear, stock);
        this.format = format;
        this.freeTrial = freeTrial;
    }

    public DigitalBook(String title, String author, int pageNumber, String genre, int publicationYear, int stock, String format, boolean freeTrial, int freeTrialLength){
        super(title, author, pageNumber, genre, publicationYear, stock);
        this.format = format;
        this.freeTrial = freeTrial;
        this.freeTrialLength = freeTrialLength;
    }

    public String getFormat() {
        return format;
    }

    public boolean isFreeTrial() {
        return freeTrial;
    }

    public int getFreeTrialLength() {
        return freeTrialLength;
    }

    @Override
    public String toString(){
        if(freeTrial == true)
            return super.toString() + " / " + format + " / " + freeTrial + " / " + freeTrialLength;

        return super.toString() + " / " + format + " / " + freeTrial;
    }
}
