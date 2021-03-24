package model;

public class PhysicalBook extends Book{
    private String coverType;
    private boolean isNew;

    public PhysicalBook(String title, String author, int pageNumber, String genre, int publicationYear, int stock, String coverType, boolean isNew){
        super(title, author, pageNumber, genre, publicationYear, stock);
        this.coverType = coverType;
        this.isNew = isNew;
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

    @Override
    public String toString(){
        return super.toString() + " / " + coverType + " / " + isNew;
    }
}
