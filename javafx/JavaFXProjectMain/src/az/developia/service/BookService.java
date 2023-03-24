package az.developia.service;

import az.developia.Book;
import az.developia.repository.BookRepository;

public class BookService {
BookRepository repository=new BookRepository();
public void add(Book b) {
	repository.add(b);
}
	
}
