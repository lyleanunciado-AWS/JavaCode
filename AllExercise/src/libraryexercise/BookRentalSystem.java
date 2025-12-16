package libraryexercise;

import java.util.ArrayList;

public class BookRentalSystem {
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
//    public static void main(String Args[]) {
//
//    BookRentalSystem aaa = new BookRentalSystem();
//
//    aaa.addBooks(new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954));
//	aaa.addBooks(new FictionBook("To Kill a Mockingbird", "Harper Lee", 1960));
//	aaa.addBooks(new NonFictionBook("The Tipping Point", "M. Gladwell", 2000));
//	aaa.addBooks(new NonFictionBook("Guns, Germs, and Steel", "Jared Diamond", 1997));
//
////    aaa.showAllBooks();
////
////    aaa.rentBooks(1);
////
////    aaa.showAllRentedBooks();
//    }
    /**
    *@param newBook
    */
    public static void addBooks(final Book newBook) {
        library.add(newBook);
//        System.out.print(newBook.getTitle() + "		");
//        System.out.print(newBook.getAuthor() + "		");
//        System.out.println(String.valueOf(newBook.getYearPublished()));
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
     */
    public static void displayAllBooks() {
    	StringBuilder sb = new StringBuilder();
        for (Book book : library) {
        	sb.append(book.getTitle() + " "
                    + book.getAuthor() + " " + book.getYearPublished() + " ");
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
            	sb.append(book.getTitle() + " "
                + book.getAuthor() + " " + book.getYearPublished() + " ");
            }
        }
        System.out.println(sb.toString());
    }
}
