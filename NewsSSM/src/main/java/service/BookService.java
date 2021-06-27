package service;

//import cn.edu.gdpu.pojo.Book;

import pojo.Book;

import java.util.List;

/**
 * @author:ws
 * @Date:2021/5/17
 * @description:learning
 */
public interface BookService {
    public int addBook(Book book);

    public int deleteBookById(int id);

    public int updateBook(Book book);

    public Book queryBookById(int id);
    public List<Book> queryAllBooks();


}
