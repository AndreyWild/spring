package aop.video4Pointcut;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {

    @Value("Преступление и наказывание")
    private String name;

    public String getName() {
        return name;
    }
}
