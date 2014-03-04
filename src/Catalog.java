import java.util.ArrayList;

import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

@invariant({"$this.catalog.size>=0"})
public class Catalog {
	//please shut up
	private class Book{
		private String author;
		private String title;
		private String publisher;
		private String year;
		private String isbn;
		
		public Book(String author, String title, String publisher, String year, String isbn) {
			this.author = author;
			this.publisher = publisher;
			this.year = year;
			this.isbn = isbn;
		}
	}
	
	public ArrayList<Book> catalog;
	
	@ensures({"$this.catalog !=null"})
	public Catalog() {
		this.catalog = new ArrayList<Book>();
	}
	
	@requires({
		"author != null",
		"title != null",
		"publisher != null",
		"year != null",
		"isbn != null",
		"$this.containsISBN(isbn) == false"
	})
	@ensures({
		"$this.containsISBN(isbn)",
		"$this.getSize() == $old($this.getSize()) + 1"
	})
	public void makeNewBook(String author, String title, String publisher, String year, String isbn) {
		Book book = new Book(author,title,publisher,year,isbn);
		catalog.add(book);
	}
	
	
	@requires({"isbn != null"})
	public boolean containsISBN(String isbn) {
		for (Book book : catalog) {
			if (book.isbn == isbn) return true;
		}
		return false;
	}
	
	public int getSize() {return 0;}
	
}
