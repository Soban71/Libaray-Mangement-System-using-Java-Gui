import java.util.Date;

public class IssueBook extends Book {

	String issueDate, returnDate;
	Date date = new Date();
	int issDay = date.getDate();
	int issMonth = date.getMonth();
	int issYear = date.getYear() % 100;
	int reDate, reMonthe, reYear;
	String memberName;
	int memberIdNumber;
	public IssueBook(String memberName,int memberIdNumber,String bookName, String authorName, String bookCatogory, int bookId, int reDate, int reMonthe,
			int reYear) {
		super(bookName, authorName, bookCatogory, bookId);
		this.reDate = reDate;
		this.reMonthe = reMonthe;
		this.reYear = reYear;
		this.memberName=memberName;
		this.memberIdNumber=memberIdNumber;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = +issDay + "-" + issMonth + "-" + issYear;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = +reDate + "-" + reMonthe + "-" + reYear;
	}

	public String getReturnDate() {
		return returnDate;
	}

}
