package org.springdata.project1_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.entities")
public class Project1SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Project1SpringbootApplication.class, args);
    }

}
