package com.kopo.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.kopo.domain.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {
	private List<Book> listOfBooks = new ArrayList<Book>();

	public BookRepositoryImpl() {
		Book book1 = new Book("001", "도둑맞은 집중력", 18800);
		book1.setAuthor("요한 하리");
		book1.setDescription(
				"\"당신의 집중력, 안녕한가요. 수험생 땐 스톱워치를 가지고 다니며 집중해서 공부한 시간만 재기도 했다. 딴 생각이 들거나 멍해질 땐 주저 없이 STOP을 눌렀다. ");
		book1.setPublisher("어크로스");
		book1.setCategory("red");
		book1.setUnitsInStock(120);
		book1.setReleaseDate("2023-04-28");
		book1.setCondition("상");

		Book book2 = new Book("002", "역행자 확장판", 19500);
		book2.setAuthor("자청");
		book2.setDescription("95퍼센트의 인간은 타고난 유전자와 본성의 꼭두각시로 살아간다.");
		book2.setPublisher("웅진지식하우스");
		book2.setCategory("red");
		book2.setUnitsInStock(35);
		book2.setReleaseDate("2023-05-29");
		book2.setCondition("상");

		Book book3 = new Book("003", "최적의 공부 뇌", 16800);
		book3.setAuthor("이케가야 유지");
		book3.setDescription("내 경쟁자는 이 책을 모르면 좋겠다.");
		book3.setPublisher("포레스트북스");
		book3.setCategory("창의적사고두뇌계발");
		book3.setUnitsInStock(300);
		book3.setReleaseDate("2023-06-28");
		book3.setCondition("상");

		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);

	}

	@Override
	public List<Book> getAllBookList() {
		// TODO Auto-generated method stub
		return listOfBooks;
	}

	@Override
	public List<Book> getBookListByCategory(String category) {
		List<Book> booksByCategory = new ArrayList<Book>();
		for (int i = 0; i < listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			if (category.equalsIgnoreCase(book.getCategory()))
				booksByCategory.add(book);
		}
		return booksByCategory;
	}

	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		// category & publisher 가 동일한 도서만 반환
		Set<Book> booksByPublisher = new HashSet<Book>();
		Set<Book> booksByCategory = new HashSet<Book>();

		Set<String> booksByFilter = filter.keySet();

		if (booksByFilter.contains("publisher")) {
			for (int i = 0; i < filter.get("publisher").size(); i++) {
				String publisherName = filter.get("publisher").get(i);
				for (int j = 0; j < listOfBooks.size(); j++) {
					Book book = listOfBooks.get(j);

					if (publisherName.equalsIgnoreCase(book.getPublisher())) {
						booksByPublisher.add(book);
					}

				}
			}
			if (booksByFilter.contains("category")) {
				for (int i = 0; i < filter.get("category").size(); i++) {
					String category = filter.get("category").get(i);
					List<Book> list = getBookListByCategory(category); // 만들어 놓은 메서드 활용
					booksByCategory.addAll(list);
				}
			}
			booksByCategory.retainAll(booksByPublisher);

		}
		return booksByCategory;
	}

	@Override
	public Book getBookById(String bookId) {
		Book bookInfo = null;
		for(int i = 0; i < listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			if(book != null && book.getBookId() != null && book.getBookId().equals(bookId)) {
				bookInfo = book;
				break;
			}
		}
		if(bookInfo == null) {
			throw new IllegalArgumentException("도서의 ID를 찾을 수 없습니다 : " + bookId);
		}
		return bookInfo;
	}

	@Override
	public void setNewBook(Book book) {
		listOfBooks.add(book);
		
	}
}
