package aop.video5Pointcut;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary {

    public void getBook(){
        System.out.println("Мы берем книгу из UniLibrary");
    }

    public void getMagazine(){
        System.out.println("Мы берем журнал из UniLibrary");
    }
}
