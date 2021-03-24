package model;

public class DigitalBook extends Book{
    private final String format;
    private final boolean freeTrial;
    private final int freeTrialLength = 3;

    public DigitalBook(int id, String title, String author, int pageNumber, String genre, int publicationYear, double userRating, double price, String format, boolean freeTrial){
        super(id, title, author, pageNumber, genre, publicationYear, userRating, price);
        this.format = format;
        this.freeTrial = freeTrial;
    }

    public void printDB(){
        System.out.println(format+" "+freeTrial+" "+freeTrialLength);
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
        else
            return super.toString() + " / " + format + " / " + freeTrial;
    }
}
