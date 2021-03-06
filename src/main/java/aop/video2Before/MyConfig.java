package aop.video2Before;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("aop.video2Before")
@EnableAspectJAutoProxy
public class MyConfig {
}
