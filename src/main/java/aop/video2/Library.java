package aop.video2;

import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {

    public void getBook(){
        System.out.println("Мы берем книгу");
    }
}
