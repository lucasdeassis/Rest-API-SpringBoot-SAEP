package ufg.inf.es.saep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class SpringBootSaepApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSaepApplication.class, args);
    }
}