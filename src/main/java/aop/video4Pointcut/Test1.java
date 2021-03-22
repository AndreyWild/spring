package aop.video4Pointcut;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Book book = context.getBean("book", Book.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
//        uniLibrary.getBook("Девять");
        uniLibrary.getBook(book);

//        uniLibrary.returnBook();
//        uniLibrary.getMagazine();






        context.close();

    }
}
