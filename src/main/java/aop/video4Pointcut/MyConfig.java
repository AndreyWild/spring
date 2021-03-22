package aop.video4Pointcut;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("aop.video4Pointcut")
@EnableAspectJAutoProxy
public class MyConfig {
}
