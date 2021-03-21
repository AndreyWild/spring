package spring_introduction.my_config2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_introduction.Cat;
import spring_introduction.Person;
import spring_introduction.Pet;


public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig2.class);

//        Pet cat1 = context.getBean("catBean", Cat.class);
//        cat1.say();
//        Pet cat2 = context.getBean("catBean", Cat.class);
//        cat2.say();

        Person person = context.getBean("personBean", Person.class);

        System.out.println(person.getSurname());
        System.out.println(person.getAge());
//        Person person2 = context.getBean("personBean", Person.class);
//        person.callYourPet();

        context.close();
    }
}
