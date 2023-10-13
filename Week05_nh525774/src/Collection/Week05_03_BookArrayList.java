package Collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Week05_03_BookArrayList {
	private ArrayList<Week05_03_Book> arrayList;
	
	public Week05_03_BookArrayList() {
		arrayList=new ArrayList<Week05_03_Book>();
	}
	
	public void addBook(Week05_03_Book book) {
		arrayList.add(book);
	}
	
	public boolean removeBook(int BookId) {
		for (int i=0;i<arrayList.size();i++) {
			Week05_03_Book book=arrayList.get(i);
			int tempId=book.getBookId();
			if(tempId==BookId) {
				arrayList.remove(i);
				return true;
			}
		}
		System.out.println(BookId+"가 존재하지 않습니다.");
		return false;
	}
	public void insertBook(int insertIndex, Week05_03_Book newBook) {
		
		for(int i=0;i<arrayList.size();i++) {
			Week05_03_Book book=arrayList.get(i);
			int tempId=book.getBookId();
			if(tempId==insertIndex) {
				arrayList.add(i, newBook);
				return;
			}
		}
	}
	
	public void showAllBook() {
		for(Week05_03_Book book:arrayList) {
			System.out.println(book);
		}
		System.out.println();
	}
}