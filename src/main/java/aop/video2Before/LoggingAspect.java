package aop.video2Before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect // https://mvnrepository.com/artifact/org.aspectj/aspectjweaver
public class LoggingAspect {

    @Before("execution(public void getBook())") // перед методом ... getBook()
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }
}
