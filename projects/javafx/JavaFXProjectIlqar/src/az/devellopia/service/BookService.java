package az.devellopia.service;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import az.devellopia.Book;
import az.devellopia.repository.BookRepository;

public class BookService {
private BookRepository bookRepository=new BookRepository();

public void add(Book b) {
	b.setRegisterTime(LocalDateTime.now());
	bookRepository.add(b);
}
 
public ArrayList<Book> findAll(){
	return bookRepository.findAll();
 }

public void delete(Integer bookId) {
	bookRepository.delete(bookId);
}

public List<Book> findAllSearch(String value){

	List<Book>  books=bookRepository.findAllSearch(value);
	
	 
return books;
}

public Integer findAllSearchCount(String Value) {

	Integer bookCount=bookRepository.findAllSearchCount(Value);
	if(bookCount>3) {
		return -1;
	}
	return bookCount;
}

public void update(Book b) {
	bookRepository.update(b);
	
}}
