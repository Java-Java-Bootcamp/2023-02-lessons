package org.example;

import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Application.class);

        var test = context.getBean(Test.class);

        test.runTest();
    }

    @Bean
    public TestElements testElements() throws IOException {
        return new TestElements("data.txt");
    }
}
