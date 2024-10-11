package library;

public class bookinfo {
	public bookinfo(int bid, String title, String author, String genre, String pub, int qty, String about) {
		super();
		this.bid = bid;
		this.title = title;// CREATE CONSTRUCTORS
		this.author = author;
		this.genre = genre;
		this.pub = pub;
		this.qty = qty;
		this.about = about;
	}

	public bookinfo() {

	}

	public bookinfo(String sname1, String sregno2, String sdept1) {

	}

	private static int bid;// CREATE GETTERS AND SETTERS
	private static String title;
	private static String author;
	private static String genre;
	private static String pub;
	private static int qty;
	private static String about;

	public static int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public static String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public static String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public static String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	public static int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public static String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
}
