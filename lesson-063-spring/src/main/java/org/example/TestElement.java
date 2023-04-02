package org.example;

public class TestElement {
    private String text;
    private String[] answers;
    private int rightAnswerIndex;

    public TestElement(String text, String[] answers, int rightAnswerIndex) {
        this.text = text;
        this.answers = answers;
        this.rightAnswerIndex = rightAnswerIndex;
    }

    public String getText() {
        return text;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getRightAnswerIndex() {
        return rightAnswerIndex;
    }
}
