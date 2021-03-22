package aop.video5Pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect // https://mvnrepository.com/artifact/org.aspectj/aspectjweaver
public class LoggingAndSecurityAspect {

    // Объявили Pointcut
    @Pointcut("execution(* get*())")
    private void allGetMethods(){}


//    @Before("execution(* get*())")
    @Before("allGetMethods()") // применили объявленный Pointcut
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу/журнал");
    }

//    @Before("execution(* get*())")
    @Before("allGetMethods()")
    public void beforeGetSecurityAdvice() {
        System.out.println("beforeGetSecurityAdvice: проверка прав на получение " +
                "книги/журнала");
    }

}
