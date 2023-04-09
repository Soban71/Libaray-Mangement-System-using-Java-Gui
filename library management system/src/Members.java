import java.util.ArrayList;

public class Members {
	ArrayList<IssueBook> issueBook=new ArrayList<>(); 
	protected String name;
	protected int idNumber,contactNumber;
	public Members(String name, int idNumber, int contactNumber) {
		super();
		this.name = name;
		this.idNumber = idNumber;
		this.contactNumber = contactNumber;
	}
	public String getName() {
		return name;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void issueBook(String memberName,int memberIdNumber,String bookName, String authorName, String bookCatogory, int bookId, int reDate, int reMonthe,
			int reYear) {
   this.issueBook.add(new IssueBook(memberName, memberIdNumber, bookName, authorName, bookCatogory, bookId, reDate, reMonthe, reYear))	;	
	}
	@Override
	public String toString() {
		return "[name=" + name + ", idNumber=" + idNumber + ", contactNumber=" + contactNumber + "]";
	}
	
}
