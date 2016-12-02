package edu.hziee.mappers;

import java.util.List;

import edu.hziee.models.Book;

public interface BookMapper {
    List<Book>findAll();
    Book findById(int id);
    void add(Book book);
    void modify(Book book);
    void delete(int id);
}
