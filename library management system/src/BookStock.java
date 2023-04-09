import java.util.Date;

public class BookStock extends Book {



public BookStock(String bookName, String authorName, String bookCatogory, int bookId) {
	super(bookName, authorName, bookCatogory, bookId);
}
public String getBookName() {
	return bookName;
}
public String getAuthorName() {
	return authorName;
}
public String getBookCatogory() {
	return bookCatogory;
}
public int getBookId() {
	return bookId;
}

@Override
public String toString() {
	return "[bookName=" + bookName + ", authorName=" + authorName + ", bookCatogory=" + bookCatogory + ", bookId="
			+ bookId + "]";
}


}
