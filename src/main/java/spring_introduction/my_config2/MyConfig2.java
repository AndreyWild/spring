package spring_introduction.my_config2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import spring_introduction.Cat;
import spring_introduction.Person;
import spring_introduction.Pet;

@Configuration // Аннотация означает что данный класс является конфигурацией
@PropertySource("classpath:myApp.properties") // указывает откуда брать value для полей
public class MyConfig2 {

    @Bean
//    @Scope("prototype")
    @Scope("singleton")
    public Pet catBean(){
        return new Cat();
    }

    @Bean // по-умолчанию singleton
    public Person personBean(){
        return new Person(catBean());

    }

}
