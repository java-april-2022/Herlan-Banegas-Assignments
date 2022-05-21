package com.herlan.bookClub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herlan.bookClub.models.Book;
import com.herlan.bookClub.repositories.BookRepository;

@Service
public class BookService {

	
	@Autowired
	private BookRepository bookRepo;
	
	//list all books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	//new book
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	//delete a book
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	//get one book
	public Book getOneBook(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	//update book
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
}
