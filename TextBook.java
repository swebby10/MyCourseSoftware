package myCourseSoftware.objects;

public class TextBook {
private String title;
private String publisher;
private double price;
/**
 * 
 * @param theTitle is the title of the book.
 * @param thePublisher is the publisher of the book.
 * @param thePrice is the price of the book.
 */
	public TextBook(String theTitle, String thePublisher, double thePrice) {
		title = theTitle;
		publisher = thePublisher;
		price = thePrice;
	}
/**
 * 
 * @return the title of the book.
 */
	public String getTitle() {
		return title;
	}
/**
 * Sets the title of the book to the passed String.
 * @param title
 */
	public void setTitle(String title) {
		this.title = title;
	}
/**
 * 
 * @return the publisher of the book.
 */
	public String getPublisher() {
		return publisher;
	}
/**
 * Sets the publisher of the book to the passed String
 * @param publisher is to be the new publisher of the book.
 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
/**
 * 
 * @return the price of the book.
 */
	public double getPrice() {
		return price;
	}
/**
 * Sets the price of the book to the passed integer.
 * @param price is to be the new price of the book.
 */
	public void setPrice(int price) {
		this.price = price;
	}

}
