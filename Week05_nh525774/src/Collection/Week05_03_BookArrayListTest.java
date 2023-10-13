package Collection;
import java.util.Scanner;

public class Week05_03_BookArrayListTest {
	
	public static void main(String[] args) {
		Week05_03_BookArrayList bookArrayList=new Week05_03_BookArrayList();
		
		Week05_03_Book book1=new Week05_03_Book(0001,"파우스트");
		Week05_03_Book book2=new Week05_03_Book(0002,"황무지");
		Week05_03_Book book3=new Week05_03_Book(0003,"변신");
		Week05_03_Book book4=new Week05_03_Book(0004,"픽션들");
		Week05_03_Book book5=new Week05_03_Book(0005,"톨스토이");
		
		bookArrayList.addBook(book1);
		bookArrayList.addBook(book2);
		bookArrayList.addBook(book3);
		bookArrayList.addBook(book4);
		bookArrayList.addBook(book5);
		
		bookArrayList.showAllBook();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("책의 아이디를 입력하세요: ");
		int bookId=sc.nextInt();
		System.out.println("책의 제목을 입력하세요: ");
		String title=sc.toString();
		System.out.println("위치를 입력하세요:");
		int insertIndex=sc.nextInt();
		
		Week05_03_Book newBook =new Week05_03_Book(bookId,title);
		bookArrayList.insertBook(insertIndex, newBook);
		
		bookArrayList.showAllBook();
		
		sc.close();

	}

}