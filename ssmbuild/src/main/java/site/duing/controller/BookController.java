package site.duing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import site.duing.pojo.Books;
import site.duing.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Controller//交给Spring容器管理
@RequestMapping("/book")
public class BookController {
    //controller层调service层
    @Autowired//自动注入
    //@Qualifier("bookService")
    private BookService bookService;

    //查询全部书籍，并且返回到书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> bookList = bookService.queryAllBook();
        model.addAttribute("bookList",bookList);
        //System.out.println(bookList);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addBook";
    }

    //增加书籍
    @RequestMapping("/addBook")
    public String addBook(Books books){
        //System.out.println("addBook==>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    //跳转到修改页面
    @RequestMapping("toUpdateBook")
    public String toUpdatePage(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("Qbook",books);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook==>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook")
    public String delateBook(int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Books> bookList = new ArrayList<Books>();
        Books books = bookService.queryBookByName(queryBookName);
        if (books != null){
            bookList.add(books);
            model.addAttribute("bookList",bookList);
        }
        return "allBook";
    }
}
