package spring_introduction.my_config1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_introduction.Person;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        context.close();

    }
}
