package Person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "Person")
public class SpringConfig {
    @Bean(name = "user")
    public User ggggg(){
        User user = new User();
        return user;
    }
}
