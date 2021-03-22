package aop.video4Pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect // https://mvnrepository.com/artifact/org.aspectj/aspectjweaver
public class LoggingAspect {


//    @Before("execution(public void getBook(String))") // добавили тип параметра переменной - String
//    public void beforeGetBookAdvice() {
//        System.out.println("beforeGetBookAdvice: попытка получить книгу");
//    }

//        @Before("execution(public void *(*))") // вызовет любой метод с одним параметром
//    public void beforeGetBookAdvice() {
//        System.out.println("beforeGetBookAdvice: попытка получить книгу");
//    }

    @Before("execution(public void getBook(aop.video4Pointcut.Book))") // вызовет любой метод с параметром Book
    // в последних версиях можно просто Book
        /** public void *(..) - c любым количеством параметров от  0 до бесконечности
         *  public void getBook(Book, ..) - c первым параметром Book, остальные любые */

    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }


    @Before("execution(* returnBook())") // * - с любым  параметром доступа и с любой return типом
    /** execution(* *()) - вообще любой метод */
    public void beforeGetReturnBookAdvice() {
        System.out.println("beforeGetReturnBookAdvice: попытка сдать книгу");
    }

}
