package nuc.crowdsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.activiti.spring.boot.SecurityAutoConfiguration.class})
@MapperScan("nuc.crowdsys.mapper")
public class CrowdsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrowdsysApplication.class, args);
    }

}