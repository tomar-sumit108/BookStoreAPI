package com.myprojects.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myprojects.bookstore.dao.BookDao;
import com.myprojects.bookstore.model.Book;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookstore")
public class BookController {
	
		@Autowired
		BookDao bookdao;
	
		@GetMapping("/book")
	    public List<Book> index(){
	        return bookdao.findAll();
	    }

	    @GetMapping("/book/id={id}")
	    public Book showId(@PathVariable String id){
	        return bookdao.findById(id);
	    }
	    
	    @GetMapping("/book/name={name}")
	    public Book showName(@PathVariable String name){
	    
	        return bookdao.findByName(name);
	    }
	    
	    @GetMapping("/book/author={author}")
	    public List<Book> showAuthor(@PathVariable String author){
	       
	        return bookdao.findByAuthorContaining(author);
	    }
	    
	    @GetMapping("/book/category={category}")
	    public List<Book> show(@PathVariable String category){
	       
	        return bookdao.findByCategory(category);
	    }

	    @PostMapping("/book")
	    public Book create(@Valid @RequestBody Book book){
	    	
	        return bookdao.save(book);
	    }

	    @PutMapping("/book/id={id}")
	    public Book update(@PathVariable String id, @RequestBody Map<String, String> book) {
	        return bookdao.update(id,book);
	    }

	    @DeleteMapping("book/id={id}")
	    public Book delete(@PathVariable String id){
	        return bookdao.deleteById(id);
	    }


	}

