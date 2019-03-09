package com.myprojects.bookstore.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myprojects.bookstore.model.Book;
import com.myprojects.bookstore.repository.BookRepository;

@Service
public class BookDao {
	
	@Autowired
	BookRepository bookrepository;

    public List<Book> findAll(){
        return bookrepository.findAll();
    }

  
    public Book findById(String id){
        int bookId = Integer.parseInt(id);
        return bookrepository.findById(bookId);
    }
    
  
    public Book findByName(String name){
    
        return bookrepository.findByName(name);
    }
    
    public List<Book> findByAuthorContaining(String author){
       
        return bookrepository.findByAuthorContaining(author);
    }
    
    
    public List<Book> findByCategory(String category){
       
        return bookrepository.findByCategory(category);
    }


    public Book save(Book book){
    	
        return bookrepository.save(book);
    }

    public Book update(String id,Map<String, String> body){
        int blogId = Integer.parseInt(id);
        Book book = bookrepository.findById(blogId);
        book.setAuthor(body.get("author"));
        book.setName(body.get("name"));
        book.setCategory(body.get("category"));
        return bookrepository.save(book);
    }

    public Book deleteById(String id){
        int bookId = Integer.parseInt(id);
        return bookrepository.deleteById(bookId);
    }


}
