package org.example;

public class TestElement {
    private String text;
    private String[] answers;
    private int rightAnswerIndex;

    private UserInput userInput;

    public TestElement(UserInput userInput, String text, String[] answers, int rightAnswerIndex) {
        this.text = text;
        this.answers = answers;
        this.rightAnswerIndex = rightAnswerIndex;
        this.userInput = userInput;
    }

    public boolean ask() {
        System.out.println(text);
        for (int i = 0; i < answers.length; i++) {
            System.out.println(answers[i]);
        }
        int userAnswer = userInput.read(1, answers.length);
        return userAnswer == rightAnswerIndex;
    }
}
