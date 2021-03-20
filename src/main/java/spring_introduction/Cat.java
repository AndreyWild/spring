package spring_introduction;

import org.springframework.stereotype.Component;

@Component //("catBean") - без параметра bean = названию класса с прописной буквы Cat --> cat,
// но class SQLTest ---> SQLTest
public class Cat implements Pet{

    public Cat() {
        System.out.println("Cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("Meow-Meow");
    }
}
