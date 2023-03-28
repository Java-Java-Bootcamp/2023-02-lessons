package ru.otus.botonsocket.server;

import java.util.TreeMap;
import ru.otus.botonsocket.dto.PollDto;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoolOfPolls {

    private static Map<Integer, PollDto> listOfPolls = new TreeMap<>(); // все опросы, ключ - ID опроса, значение - объект опроса

    // возвращает сохранненные опросы
    public static Collection<PollDto> showPolls() {
        return listOfPolls.values();
    }

    // добавляем новый опрос
    public void addPoll(PollDto poll) {
        poll.setId(getID());
        listOfPolls.put(poll.getId(), poll);
    }

    public void vote(int pollId, int answerNo) {
        listOfPolls.get(pollId).vote(answerNo);
    }

    public Collection<PollDto> getPolls() {
        return listOfPolls.values();
    }

    // "генерирует" следующий идентификатор для опроса
    private int getID() {
        return listOfPolls.size() + 1;
    }


}
