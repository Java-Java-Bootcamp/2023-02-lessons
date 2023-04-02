package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Application.class);

        var userInput = context.getBean(UserInput.class);
        var userOutput = context.getBean(UserOutput.class);

        var testElements = context.getBean(TestElements.class);

        Test test = new Test(userOutput, userInput, testElements);

        test.runTest();
    }

    @Bean
    public TestElements testElements() {
        TestElement testElement = new TestElement("1+2", new String[]{"1", "2", "3", "4"}, 3);
        TestElement testElement2 = new TestElement("1+2", new String[]{"1", "2", "4"}, 3);
        TestElement testElement3 = new TestElement("1+4", new String[]{"3", "4"}, 3);

        return new TestElements(new TestElement[]{testElement, testElement2, testElement3});
    }
}
