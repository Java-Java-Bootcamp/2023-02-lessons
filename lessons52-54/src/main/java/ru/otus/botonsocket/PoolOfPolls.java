package ru.otus.botonsocket;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoolOfPolls {
    private static Map<Integer, Poll> listOfPolls = new HashMap<>(); // все опросы, ключ - ID опроса, значение - объект опроса

    // возвращает сохранненные опросы
    public static Collection<Poll> showPolls(){
        return listOfPolls.values();
    }

    // добавляем новый опрос
    public void addPoll(Poll poll) {

        listOfPolls.put(getID(), poll);
    }

    // добавляем новый опрос
    public void addPoll(String question, List<String> answers){

        Poll poll = new Poll(question, answers);
        listOfPolls.put(getID(), poll);
    }

    // "генерирует" следующий идентификатор для опроса
    private int getID() {
        return listOfPolls.size() + 1;
    }


}
