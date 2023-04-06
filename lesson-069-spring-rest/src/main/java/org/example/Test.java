package org.example;

import org.springframework.stereotype.Service;

@Service
public class Test {
    private TestElement[] blocks;

    private int correctCount;
    private int wrongCount;

    private UserOutput userOutput;
    private final UserInput userInput;

    public Test(UserOutput userOutput, UserInput userInput, TestElements blocks) {
        this.blocks = blocks.getElements();
        this.userOutput = userOutput;
        this.userInput = userInput;
    }

    private boolean ask(TestElement element) {
        userOutput.print(element.getText());
        for (int i = 0; i < element.getAnswers().length; i++) {
            userOutput.print(element.getAnswers()[i]);
        }
        int userAnswer = userInput.read(1, element.getAnswers().length);
        return userAnswer == element.getRightAnswerIndex();
    }

    public void runTest() {
        for (TestElement block : blocks) {
            if(ask(block)) {
                correctCount++;
                userOutput.print("Right!");
            } else {
                wrongCount++;
                userOutput.print("Wrong!");
            }
        }
        userOutput.print("Result: correct - " + correctCount + " wrong - " + wrongCount);
    }
}
