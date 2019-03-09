package com.myprojects.bookstore.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myprojects.bookstore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
	
	Book findById(int id);
	Book findByName(String name);
	List<Book> findByCategory(String category);
	List<Book> findByAuthorContaining(String author);
	Book deleteById(int id);
}
