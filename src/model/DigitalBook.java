package model;

public class DigitalBook extends Book{
    private final String format;
    private final boolean freeTrial;
    private final int freeTrialLength = 3;

    public DigitalBook(int i, String t, String a, int pN, String g, int pY, double uR, int p, String f, boolean fT){
        super(i, t, a, pN, g, pY, uR, p);
        this.format = f;
        this.freeTrial = fT;
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
}
