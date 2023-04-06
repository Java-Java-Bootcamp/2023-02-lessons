package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public TestElements testElements() {
        TestElement testElement = new TestElement("1+2", new String[]{"1", "2", "3", "4"}, 3);
        TestElement testElement2 = new TestElement("1+2", new String[]{"1", "2", "4"}, 3);
        TestElement testElement3 = new TestElement("1+4", new String[]{"3", "4"}, 3);

        return new TestElements(new TestElement[]{testElement, testElement2, testElement3});
    }
}
