package com.kodluyoruz.homeworkthree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.kodluyoruz.homeworkthree.properties")
public class HomeworkThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkThreeApplication.class, args);
    }

}
