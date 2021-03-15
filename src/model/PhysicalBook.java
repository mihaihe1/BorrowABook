package model;

public class PhysicalBook extends Book{
    private String coverType;
    private boolean isNew;

    public PhysicalBook(int i, String t, String a, int pN, String g, int pY, double uR, int p, String cT, boolean iN){
        super(i, t, a, pN, g, pY, uR, p);
        this.coverType = cT;
        this.isNew = iN;
    }

    public void printPB(){
        System.out.println(coverType+" "+isNew);
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
