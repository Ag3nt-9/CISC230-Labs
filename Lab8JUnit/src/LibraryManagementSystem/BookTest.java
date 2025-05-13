package LibraryManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BookTest {

	@Test
	void testBookGetters() {
		Book book = new Book("1984", "George Orwell", "1234567890");
		assertEquals("1984", book.getTitle());
		assertEquals("George Orwell", book.getAuthor());
		assertEquals("1234567890", book.getISBN());
		assertTrue(book.getAvailability());
	}

	@Test
	void testBorrowAndReturn() {
		Book book = new Book("1984", "George Orwell", "1234567890");
		assertTrue(book.borrowBook());
		assertFalse(book.getAvailability());
		assertFalse(book.borrowBook());
		assertTrue(book.returnBook());
		assertTrue(book.getAvailability());
	}

	@ParameterizedTest
	@ValueSource(strings = {"1234567890", "1234567890123"})
	void testValidISBNs(String isbn) {
		assertDoesNotThrow(() -> new Book("Title", "Author", isbn));
	}

	@ParameterizedTest
	@ValueSource(strings = {"123", "abcdefghij", "", "12345678901"})
	void testInvalidISBNs(String isbn) {
		assertThrows(IllegalArgumentException.class, () -> new Book("Title", "Author", isbn));
	}

	@Test
	void testMemberBorrowReturn() {
		Library library = new Library();
		Book book = new Book("Moby Dick", "Herman Melville", "1234567890");
		library.addBook(book);
		Member member = new Member("Alice");

		member.borrowBook(library, "Moby Dick");
		assertFalse(book.getAvailability());

		member.returnBook(library, "Moby Dick");
		assertTrue(book.getAvailability());
	}

	@Test
	void testReturnBookNotBorrowedByMember() {
		Library library = new Library();
		Book book = new Book("Dracula", "Bram Stoker", "9876543210");
		library.addBook(book);
		Member member = new Member("John");

		// Book not borrowed by member
		member.returnBook(library, "Dracula");
	}
}
