package dao;

//import cn.edu.gdpu.pojo.Book;

import pojo.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(int id);

    public int updateBook(Book book);

    public Book queryBookById(int id);

    public List<Book> queryAllBooks();
}
