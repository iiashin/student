package service;

//import cn.edu.gdpu.dao.BookDao;
//import cn.edu.gdpu.pojo.Book;
import dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Book;

import java.util.List;

/**
 * @author:ws
 * @Date:2021/5/17
 * @description:learning
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryAllBooks() {
//        System.out.println("test");
        return bookDao.queryAllBooks();
    }
}
