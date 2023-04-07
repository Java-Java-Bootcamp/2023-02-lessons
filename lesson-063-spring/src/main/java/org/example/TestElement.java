package org.example;

import java.util.List;

public class TestElement {
    private String text;
    private List<String> answers;
    private int rightAnswerIndex;

    public TestElement(String text, List<String> answers, int rightAnswerIndex) {
        this.text = text;
        this.answers = answers;
        this.rightAnswerIndex = rightAnswerIndex;
    }

    public String getText() {
        return text;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public int getRightAnswerIndex() {
        return rightAnswerIndex;
    }
}
