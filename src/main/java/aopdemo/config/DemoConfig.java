package aopdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //spring pure java configuration
@EnableAspectJAutoProxy //Spring AOP Proxy support
@ComponentScan("aopdemo") //recurse and get component classes
public class DemoConfig {
}
