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

	 ArrayList<Book>  books=bookRepository.findAll();
	List<Book> booksFiltered= books.stream().filter(n->n.getName().contains(value)).collect(Collectors.toList());
	 
return booksFiltered;
}}
