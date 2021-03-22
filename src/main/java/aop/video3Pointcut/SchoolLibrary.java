package aop.video3Pointcut;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary{

    @Override
    public void getBook(){
        System.out.println("Мы берем книгу из SchoolLibrary");
    }

    public void returnBook(){
        System.out.println("Мы возвращаем книгу в SchoolLibrary");
    }
}
