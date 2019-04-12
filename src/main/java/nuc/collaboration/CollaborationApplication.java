package nuc.collaboration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@EnableAutoConfiguration
@ComponentScan("nuc.web.controller")
public class CollaborationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollaborationApplication.class, args);
    }

}
