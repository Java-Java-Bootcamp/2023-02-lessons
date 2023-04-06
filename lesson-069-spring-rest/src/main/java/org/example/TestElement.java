package org.example;

public class TestElement {
    private int id;
    private String text;
    private String[] answers;
    private int rightAnswerIndex;

    public TestElement(int id, String text, String[] answers, int rightAnswerIndex) {
        this.id = id;
        this.text = text;
        this.answers = answers;
        this.rightAnswerIndex = rightAnswerIndex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
