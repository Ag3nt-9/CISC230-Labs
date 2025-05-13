package LibraryManagementSystem;

import java.util.ArrayList;

public class Member {
	private String name;
	private ArrayList<String> borrowedBooks = new ArrayList<String>();
	
	public Member(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void borrowBook(Library library, String title) {
		if (library.borrowBook(title)) {
			borrowedBooks.add(title);
			System.out.println(name + " borrows '" + title + "'...");
		} else {
			System.out.println(title + " not available.");
		}
	}
	
	public void returnBook(Library library, String title) {
		if (borrowedBooks.contains(title)) {
			if (library.returnBook(title)) {
				borrowedBooks.remove(title);
				System.out.println(name + " returns '" + title + "'...");
			}
		} else {
			System.out.println(title + " was not checked out by " + name);
		}
	}

}
