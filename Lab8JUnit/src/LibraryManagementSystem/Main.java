package LibraryManagementSystem;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library library = new Library();
		Member alice = new Member("Alice");
		Member john = new Member("John");
		
		library.addBook(new Book("Percy Jackson", "Rick Riordan"));
		library.addBook(new Book("1984", "George Orwell"));
		library.addBook(new Book("Percy Jackson", "Rick Riordan"));
		library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
		
		library.displayBooks();
		alice.borrowBook(library, "Percy Jackson");
		alice.borrowBook(library, "1984");
		
		library.searchBook("Percy Jackson");
		john.borrowBook(library, "Percy Jackson");
		john.returnBook(library, "1984");
		john.borrowBook(library, "1984");
		
		library.displayBooks();
	}

}
