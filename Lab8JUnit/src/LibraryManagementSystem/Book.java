package LibraryManagementSystem;

public class Book {
	private String title;
	private String author;
	private boolean isAvailable;
	private String isbn;
	
	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		setISBN(isbn);
		this.isAvailable = true;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public boolean getAvailability() {
		return isAvailable;
	}
	
	public boolean borrowBook() {
		if (isAvailable) {
			isAvailable = false;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean returnBook() {
		if (!isAvailable) {
			isAvailable = true;
			return true;
		} else {
			return false;
		}
	}
	
	public void setISBN(String isbn) {
		if (!isbn.matches("\\d{10}|\\d{13}")) {
			throw new IllegalArgumentException("Invalid ISBN format");
		}
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		String availableString = isAvailable ? "Available" : "Checked Out";
		return title + " by " + author + " (ISBN: " + isbn + ") - " + availableString;
	}

	public String getISBN() {
		return isbn;
	}

}
