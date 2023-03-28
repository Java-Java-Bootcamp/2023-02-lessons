package ru.otus.botonsocket;

import java.util.List;

public class Poll {
    //private int id;
    private String pollQuestion;
    private List<String> listOfOptions;

    public Poll(String pollQuestion, List<String> listOfOptions) {
        this.pollQuestion = pollQuestion;
        this.listOfOptions = listOfOptions;
    }

    /*public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getPollQuestion() {
        return pollQuestion;
    }

    public void setPollQuestion(String pollQuestion) {
        this.pollQuestion = pollQuestion;
    }

    public List<String> getListOfOptions() {
        return listOfOptions;
    }

    public void setListOfOptions(List<String> listOfOptions) {
        this.listOfOptions = listOfOptions;
    }

    @Override
    public String toString() {
        return "Poll{" +
                //"id=" + id +
                ", pollQuestion='" + pollQuestion + '\'' +
                ", listOfOptions=" + listOfOptions +
                '}';
    }
}
