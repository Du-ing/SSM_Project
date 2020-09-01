package site.duing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.duing.dao.BookMapper;
import site.duing.pojo.Books;
import site.duing.service.BookService;

import java.util.List;

@Service//交给Spring容器管理
@Transactional//开启事务管理，所有的方法都会植入事务处理
public class BookServiceImpl implements BookService {
    //service层调dao层
    @Autowired//自动注入
    private BookMapper bookMapper;

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
