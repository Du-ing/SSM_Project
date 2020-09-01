import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import site.duing.pojo.Books;
import site.duing.service.BookService;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService service = context.getBean("BookServiceImpl", BookService.class);
        for (Books books : service.queryAllBook()) {
            System.out.println(books);
        }
    }

//    @Test
//    public void test1(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BookService service = context.getBean("BookServiceImpl", BookService.class);
//        Books book = new Books("")
//        service.addBook()
//    }
}
