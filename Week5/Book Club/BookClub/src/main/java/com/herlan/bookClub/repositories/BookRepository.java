package com.herlan.bookClub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.herlan.bookClub.models.Book;
import com.herlan.bookClub.models.User;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();
	List<Book> findAllByUser(User user);

}
