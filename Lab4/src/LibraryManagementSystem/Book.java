package LibraryManagementSystem;

public class Book {
	private String title;
	private String author;
	private boolean isAvailable;
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
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
	
	@Override
	public String toString() {
		String availableString = "";
		if (isAvailable) {
			availableString = "Available";
		} else {
			availableString = "Checked Out";
		}
		return title + " by " + author + " - " + availableString;
	}

}
