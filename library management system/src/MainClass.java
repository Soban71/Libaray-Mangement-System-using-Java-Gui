import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainClass {
	static ArrayList<BookStock> bookStock;
	static ArrayList<Members> members;
	static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		bookStock=new ArrayList<BookStock>();
		members=new ArrayList<Members>();
		
		
		adminOrUser();

	}

	static public void adminOrUser() {

		do {
			System.out.println("Press 1 For Admin Portal ");

			System.out.println("Press 2 For User Portal ");

			System.out.println("Press 0 To Terminate");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {

				int select;
				do {
					adminMenu();

					select = sc.nextInt();
					switch (select) {
					case 1:
						addBook();
						break;

					case 2:

						addMember();
						break;

					case 3:
						issueBookToMember();

						break;

					case 4:
						avalibaleBooks();
						break;

					case 5:
						members();
						break;
						
					case 6:
						returnBook();
						break;
					}

				} while (select != 0); // Nesting Switch
				break;
			}
			// _________________________________________________

			case 2: {
				userMenu();
				avalibaleBooks();

			}
			case 0:
				System.exit(0);
			}
		} while (true);
	}

	static public void adminMenu() {
		System.out.println("Press 1 To Add Book");
		System.out.println("Press 2 To Add Members");
		System.out.println("Press 3 To Issue Bokks to Members");
		System.out.println("Press 4 TO Show list of Book");
		System.out.println("Press 5 To Show All Members");
		System.out.println("Press 6 To Return Book");
		System.out.println("Press 0 To Exit");

	}
	
	static public void userMenu() {
		
		System.out.println("Press 1 TO Show list of Book");
        
		
	}

	static public void addBook() {
		int choice;
		do {
			System.out.println("Press 1 TO Add Book");
			System.out.println("Press 0 To Skip");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter The Book Name");

				String bookName = sc.next();

				System.out.println("Enter The Author Name");

				String authorName = sc.next();

				System.out.println("Enter The book Catogory");

				String bookCatogory = sc.next();

				System.out.println("Enter The Book Id");
       
				int bookId = sc.nextInt();
				
				bookStock.add(new BookStock(bookName, authorName, bookCatogory, bookId));

				break;

			}

		} while (choice != 0);
	}

	static public void addMember() {

		int choice;
		do {
			System.out.println("Press 1 TO Add Members");
			System.out.println("Press 0 To Skip");
			choice = sc.nextInt();
			switch (choice) {
			case 1:

				System.out.println("Enter The Name");

				String name = sc.next();

				System.out.println("Enter The 13 Digit IdNumber Without -");

				int idNumber = sc.nextInt();

				System.out.println("Enter The Contact Number");

				int contactNumber = sc.nextInt();

				members.add(new Members(name, idNumber, contactNumber));

				break;

			}

		} while (choice != 0);

	}

	static public void issueBookToMember() {

		System.out.println("Enter The Name of Member");

		String name = sc.next();

		System.out.println("Enter The 13 Digit IdNumber Without -");

		int idNumber = sc.nextInt();
		String bookName = null;
		boolean found = false;
		int ind = 0;
		int bookId = 0;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).idNumber == idNumber) {
				found = true;
				ind = i;

			}
		}
		boolean bookFound = false;
		if (found) {
			System.out.println("Enter the Book name");

			bookName = sc.next();

			System.out.println("Enter the Book Id");

			bookId = sc.nextInt();
			for (int j = 0; j < bookStock.size(); j++) {
				if (bookStock.get(j).bookId == bookId) {
					bookFound = true;
					System.out.println("Enter a Return date in DD/MM/YY Form");

					System.out.println("Enter a Day");

					int reDate = sc.nextInt();

					System.out.println("Enter a Month");

					int reMonthe = sc.nextInt();

					System.out.println("Enter a Month");

					int reYear = sc.nextInt();

					members.get(ind).issueBook(members.get(ind).name, members.get(ind).idNumber,
							bookStock.get(j).bookName, bookStock.get(j).authorName, bookStock.get(j).bookCatogory,
							bookStock.get(j).bookId, reDate, reMonthe, reYear);
					bookStock.remove(j);

					// file refresh..........

				}

			}
		} else
			System.out.println(name + "is not a Member");
		if (bookFound == false) {
			System.out.println(bookName + "Is not Avalibale in library");
		}
	}

	static public void avalibaleBooks() {
		for (int i = 0; i < bookStock.size(); i++) {
			System.out.println(bookStock.get(i));
		}
	}

	static public void members() {
		for (int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i));

		}
	}

	static public void returnBook() {
		

		int idNumber = sc.nextInt();
		int fine=0;
		boolean found=false;
		
		do {
		System.out.println("Enter The Name of Member");

		String name = sc.next();

		System.out.println("Enter The 13 Digit IdNumber Without -");
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).issueBook.get(i).memberIdNumber == idNumber) {
                  found=true;
				bookStock.add(new BookStock(members.get(i).issueBook.get(i).bookName,
						members.get(i).issueBook.get(i).authorName, members.get(i).issueBook.get(i).bookCatogory,
						members.get(i).issueBook.get(i).bookId));
				  
				if(members.get(i).issueBook.get(i).reMonthe==new Date().getMonth())
				{
					for(int j=members.get(i).issueBook.get(i).reDate;j<=new Date().getDate();i++)
					{
					fine=fine+10;
						
					}
					
				}
				else 
				{
					
					for(int j=members.get(i).issueBook.get(i).reMonthe;j<=new Date().getMonth();i++)
					{
					fine=fine+300;
						
					}
				}
				if(fine>0)
				{
					System.out.println(name+",Your Fine is "+fine);
				}
				    members.get(i).issueBook.remove(i);
				// file refresh..........

			}
		}}while(found!=true);
		
		if(found==false) {
			System.out.println("Enter incorrect Name or Id Number Try again");
		}

	}

}
