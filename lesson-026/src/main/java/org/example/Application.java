package org.example;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new ConsoleUserInput();
        UserOutput userOutput = new ConsoleOutput();
        TestElement testElement = new TestElement(userInput, "1+2", new String[]{"1", "2", "3", "4"}, 3);
        TestElement testElement2 = new TestElement(userInput, "1+2", new String[]{"1", "2", "4"}, 3);
        TestElement testElement3 = new TestElement(userInput, "1+4", new String[]{"3", "4"}, 3);

        Test test = new Test(userOutput, new TestElement[]{testElement, testElement2, testElement3});

        test.runTest();
    }
}
