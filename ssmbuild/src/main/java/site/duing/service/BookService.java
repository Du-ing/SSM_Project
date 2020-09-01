package site.duing.service;

import org.apache.ibatis.annotations.Param;
import site.duing.pojo.Books;

import java.util.List;

public interface BookService {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(int id);
    //更新一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBookById(int id);
    //查询全部的书
    List<Books> queryAllBook();
    //根据书名查找
    Books queryBookByName(String bookName);
}
