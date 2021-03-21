package spring_introduction.my_config1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Аннотация означает что данный класс является конфигурацией
@ComponentScan("spring_introduction") // Указывает какой пакет сканировать на наличие бинов и аннотаций
public class MyConfig {
}
