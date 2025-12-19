package libraryexercise;

import java.util.ArrayList;

public final class BookRentalSystem {
    /**
     *
     */
    private BookRentalSystem() {
        super();
    }
    /**
    *
    */
    private static ArrayList<Book> library = new ArrayList<Book>();
    /**
    *@return library
    */
    public static ArrayList<Book> getLibrary() {
        return library;
    }
    /**
    *
    */
    public static void clearLibrary() {
        library.clear();
    }
    /**
    *@return library size
    */
    public static int getLibrarySize() {
        return library.size();
    }
    /**
    *@param newBook
    */
    public static void addBooks(final Book newBook) {
        library.add(newBook);
    }
    /**
     *@param newArrayOfBooks
     */
    public static void addBooks(final ArrayList<Book> newArrayOfBooks) {
        for (Book book: newArrayOfBooks) {
            library.add(book);
        }
    }
    /**
    *
    * @param index
    */
    public static void rentBooks(final int index) {
        library.get(index).rent();
    }
    /**
    *
    * @param indexes
    */
    public static void rentBooks(final int[] indexes) {
        for (int index: indexes) {
            library.get(index).rent();
        }
    }
    /**
     *
     */
    public static void displayAllBooks() {
        StringBuilder sb = new StringBuilder();
        for (Book book : library) {
            sb.append(book.getTitle() + "   "
            + book.getAuthor() + "      "
            + book.getYearPublished() + "\n");
        }
        System.out.println(sb.toString());
    }
    /**
     *
     */
    public static void displayRentedBooks() {
        StringBuilder sb = new StringBuilder();
        for (Book book : library) {
            if (book.isRented()) {
                sb.append(book.getTitle() + "   "
                + book.getAuthor() + "      "
                + book.getYearPublished() + "\n");
            }
        }
        System.out.println(sb.toString());
    }
    /**
     * @param args
     */
    public static void main(final String[] args) {
        ArrayList<Book> newAddition = new ArrayList<Book>();
        final int year1 = 1954;
        final int year2 = 1960;
        final int year3 = 2000;

        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", year1);
        FictionBook book2 = new FictionBook("To Kill a Mockingbird",
            "Harper Lee", year2);
        NonFictionBook book3 = new NonFictionBook("The Tipping Point",
            "M. Gladwell", year3);
        newAddition.add(book1);
        newAddition.add(book2);
        newAddition.add(book3);
        addBooks(newAddition);

        displayAllBooks();
        int[] toRent = {1, 2};
        rentBooks(toRent);
        displayRentedBooks();
    }
}

