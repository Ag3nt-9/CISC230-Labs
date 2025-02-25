package LibraryManagementSystem;

import java.util.ArrayList;

public class Library {
	private ArrayList<Book> books = new ArrayList<Book>();
	
	public Library() {
		
	}
	
	public void addBook(Book book) {
		if (books.add(book)) {
			System.out.println(book + " successfully added.");
		}
	}
	
	public void removeBook(String title) {
		for (Book book: books) {
			if (book.getTitle() == title) {
				if (books.remove(book)) {
					System.out.println(book + " successfully removed.");
					return;
				}
			}
		}
		System.out.println(title + " not found.");
	}
	
	public void displayBooks() {
		for (Book book: books) {
			System.out.println(book.toString());
		}
	}
	
	public void searchBook(String title) {
		boolean bookFound = false;
		for (Book book: books) {
			if (book.getTitle() == title) {
				System.out.println(book.toString());
				bookFound = true;
			}
		}
		if (!bookFound) {
			System.out.println(title + " not found.");
		}
	}
	
	public boolean borrowBook(String title) {
		for (Book book: books) {
			if (book.getTitle() == title) {
				if (book.borrowBook()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean returnBook(String title) {
		for (Book book: books) {
			if (book.getTitle() == title) {
				if (book.returnBook()) {
					return true;
				}
			}
		}
		return false;
	}
}
