package edu.hziee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.hziee.mappers.BookMapper;
import edu.hziee.models.Book;

@Repository
public class BookDao {
    @Autowired
    BookMapper bookMapper;
    public List<Book> findAll(){
    	return bookMapper.findAll();
    }
    public Book findById(int id){
    	return bookMapper.findById(id);
    }
    public void add(Book book){
    	bookMapper.add(book);
    }
    public void modify(Book book){
    	bookMapper.modify(book);
    }
    public void delete(int id){
    	bookMapper.delete(id);
    }
}
