package libraryexercise;

public class Book {
    /**
    *
    */
    private String title;
    /**
    *
    */
    private String author;
    /**
    *
    */
    private int yearPublished;
    /**
    *
    */
    private boolean isRented;
    /**
    * @param title1
    * @param author1
    * @param yearPublished1
    */
    public Book(final String title1,
        final String author1, final int yearPublished1) {
        this.title = title1;
        this.author = author1;
        this.yearPublished = yearPublished1;
        this.isRented = false;
    }
    /**
    *
    * @return isRented Value
    */
    public boolean isRented() {
        return this.isRented;
    }
    /**
    *
    *
    */
    public void rent() {
        this.isRented = true;
    }
    /**
    *@return title
    *
    */
    public String getTitle() {
        return title;
    }
    /**
    *@return author
    *
    */
    public String getAuthor() {
        return author;
    }
    /**
     *@return yearPublished
     *
     */
    public int getYearPublished() {
        return yearPublished;
    }
}
