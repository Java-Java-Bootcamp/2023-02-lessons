package ru.otus.botonsocket.dto;

import java.util.ArrayList;
import java.util.List;

public class PollDto {
    private int id;
    private String pollQuestion;
    private List<String> listOfOptions;
    private List<Integer> listOfVotes;

    public PollDto(String pollQuestion, List<String> listOfOptions) {
        this(0, pollQuestion, listOfOptions, List.of());
    }

    public PollDto(int id, String pollQuestion, List<String> listOfOptions) {
        this(id, pollQuestion, listOfOptions, List.of());
    }

    public PollDto(int id, String pollQuestion, List<String> listOfOptions, List<Integer> listOfVotes) {
        this.id = id;
        this.pollQuestion = pollQuestion;
        this.listOfOptions = listOfOptions;

        // если передан пустой список, то считаем что 0 голосов по каждому ответу
        if (listOfVotes.isEmpty()) {
            listOfVotes = new ArrayList<>(listOfOptions.size());
            for (int i = 0; i < listOfOptions.size(); ++i)
                listOfVotes.add(0);
        }

        this.listOfVotes = listOfVotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<Integer> getListOfVotes() {
        return listOfVotes;
    }

    public void vote(int answerNo) {
        listOfVotes.set(answerNo, listOfVotes.get(answerNo) + 1);
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", pollQuestion='" + pollQuestion + '\'' +
                ", listOfOptions=" + listOfOptions +
                '}';
    }
}
