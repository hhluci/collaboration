package nuc;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("nuc.mapper")
public class CollaborationApplication {
    protected static final Logger logger = LoggerFactory.getLogger(CollaborationApplication.class);

    public static void main(String[] args) {
        logger.info("SpringBoot开始加载");
        SpringApplication.run(CollaborationApplication.class, args);
        logger.info("SpringBoot加载完毕");

    }

}
