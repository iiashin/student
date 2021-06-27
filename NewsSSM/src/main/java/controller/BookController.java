package controller;

//import cn.edu.gdpu.pojo.Book;
//import cn.edu.gdpu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Book;
import service.BookService;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("allBooks")
    public String allBooks(Model model) {
        List<Book> books = bookService.queryAllBooks();
        model.addAttribute("books", books);
        return "books";
    }
}
