package aop.video3Pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect // https://mvnrepository.com/artifact/org.aspectj/aspectjweaver
public class LoggingAspect {

//    @Before("execution(public void aop.video3Pointcut.UniLibrary.getBook())") // перед методом ... (полный путь)getBook()
//    public void beforeGetBookAdvice(){
//        System.out.println("beforeGetBookAdvice: попытка получить книгу");
//    }

    @Before("execution(public void get*())") // перед методом ... который начинается с get
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }

//    @Before("execution(public void returnBook())")
//    public void beforeGetReturnBookAdvice() {
//        System.out.println("beforeGetReturnBookAdvice: попытка сдать книгу");
//    }

    @Before("execution(* returnBook())") // * - с любым  параметром доступа и с любой return типом
    // execution(* *()) - вообще любой метод
    public void beforeGetReturnBookAdvice() {
        System.out.println("beforeGetReturnBookAdvice: попытка сдать книгу");
    }

}
