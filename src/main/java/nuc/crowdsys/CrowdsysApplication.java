package nuc.crowdsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("nuc.crowdsys.mapper")
public class CrowdsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrowdsysApplication.class, args);
    }

}