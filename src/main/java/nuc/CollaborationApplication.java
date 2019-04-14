package nuc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("nuc.mapper")
public class CollaborationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollaborationApplication.class, args);
    }

}
