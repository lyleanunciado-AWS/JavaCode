package libraryexercise;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import libraryexercise.BookRentalSystem;
import libraryexercise.FictionBook;
import libraryexercise.NonFictionBook;

class BookRentalSystemTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeEach
	void setupBeforeEach() {
		BookRentalSystem.clearLibrary();
		outContent.reset();
        System.setOut(new PrintStream(outContent));

	}

	@Test
	void testBook_AddABook_MustReturnNotNullandNotRented() {
		Book book = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
		ArrayList<Book> library = BookRentalSystem.getLibrary();
		
		BookRentalSystem.addBooks(book);
		
		assertNotEquals(book, null);
		assertEquals(false, library.get(0).isRented());
	}
	
	@Test
	void testRent_AddNewBookThenRentIt_NewBookMustReturnRented() {
		FictionBook fiction = new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954);
		ArrayList<Book> library = BookRentalSystem.getLibrary();
		
		BookRentalSystem.addBooks(fiction);
		library.get(0).rent();
		
		assertEquals(true,library.get(0).isRented());
	}
	
	@Test 
	void testAddBooks_AddOneFictionAndOneNonFiction_MustReturn2() {
        FictionBook fiction = new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        NonFictionBook nonFiction = new NonFictionBook("The Tipping Point", "M. Gladwell", 2000);
        
        BookRentalSystem.addBooks(nonFiction);
        BookRentalSystem.addBooks(fiction);
        int size = BookRentalSystem.getLibrarySize();
        
        assertEquals(2, size);
	}
	
	@Test
	void testRentBook_UseValidIndex_MustNotReturnError() {
		FictionBook fiction = new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        NonFictionBook nonFiction = new NonFictionBook("The Tipping Point", "M. Gladwell", 2000);
        
		BookRentalSystem.addBooks(fiction);
		BookRentalSystem.addBooks(nonFiction);
		BookRentalSystem.rentBooks(0);
		ArrayList<Book> library = BookRentalSystem.getLibrary();
		
		assertEquals(true,library.get(0).isRented());
		assertEquals(false,library.get(1).isRented());
	}
	
	@Test
	void testRentBook_UseInvalidIndex_MustReturnError() {
		FictionBook fiction = new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954);
		
		BookRentalSystem.addBooks(fiction);
		IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			BookRentalSystem.rentBooks(1);
		});
		
		assertEquals("Index 1 out of bounds for length 1",exception.getMessage());
	}
	
	@Test
	void testDisplayAllBooks_AddOneFictionOneNon_ExpectedAndActualMustReturnEqual() {
		FictionBook fiction = new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        NonFictionBook nonFiction = new NonFictionBook("The Tipping Point", "M. Gladwell", 2000);
        
        BookRentalSystem.addBooks(fiction);
		BookRentalSystem.addBooks(nonFiction);
		BookRentalSystem.displayAllBooks();
		String actualOutput = outContent.toString().trim();
		
		assertEquals("The Lord of the Rings   J.R.R. Tolkien      1954\nThe Tipping Point   M. Gladwell      2000",actualOutput);
	}
	
	@Test
	void testDisplayRentedBooks_AddOneFictionOneNonRentOneBook_ExpectedAndActualMustReturnEqual() {
		FictionBook fiction = new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        NonFictionBook nonFiction = new NonFictionBook("The Tipping Point", "M. Gladwell", 2000);
        ArrayList<Book> newBooks = new ArrayList<Book>();
        
        newBooks.add(fiction);
        newBooks.add(nonFiction);
        BookRentalSystem.addBooks(newBooks);
		BookRentalSystem.rentBooks(0);
		BookRentalSystem.displayRentedBooks();
		String actualOutput = outContent.toString().trim();
		
		assertEquals("The Lord of the Rings   J.R.R. Tolkien      1954",actualOutput);
	}
	
	@Test
	void testMain_DummyTest_MustReturnVoid() {
		BookRentalSystem.main(null);
	}
}
