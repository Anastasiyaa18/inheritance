package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void findTaskAtTitle() {
        SimpleTask simpleTask = new SimpleTask(16, "Сходить в магазин за покупками");

        boolean expected = true;
        boolean actual = simpleTask.matches("Сходить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findTaskWhoNoAtTitle() {
        SimpleTask simpleTask = new SimpleTask(16, "Сходить в магазин за покупками");

        boolean expected = false;
        boolean actual = simpleTask.matches("Помыть");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findMatchesInSubtasks() {

        String[] subtasks = {"Помыть посуду", "Погулять с собакой", "Сделать дз по учебе"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("учебе");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findMatchesWhoNoInSubtasks() {

        String[] subtasks = {"Помыть посуду", "Погулять с собакой", "Сделать дз по учебе"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findMatchesInProject() {

        Meeting meeting = new Meeting(
                555,
                "Обсуждение списание ТМЦ",
                "Бухгалтерия 2.0",
                "Среда, 16:00"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Бухгалтерия");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findMatchesInTopic() {

        Meeting meeting = new Meeting(
                555,
                "Обсуждение списание ТМЦ",
                "Бухгалтерия 2.0",
                "Среда, 16:00"
        );

        boolean expected = true;
        boolean actual = meeting.matches("ТМЦ");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findMatchesInTopicAndProject() {

        Meeting meeting = new Meeting(
                555,
                "Обсуждение списание ТМЦ 2.0",
                "Бухгалтерия 2.0",
                "Среда, 16:00"
        );

        boolean expected = true;
        boolean actual = meeting.matches("2.0");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findMatchesWhoNoInTopicAndProject() {

        Meeting meeting = new Meeting(
                555,
                "Обсуждение списание ТМЦ",
                "Бухгалтерия 2.0",
                "Среда, 16:00"
        );

        boolean expected = false;
        boolean actual = meeting.matches("тестирование");

        Assertions.assertEquals(expected, actual);
    }
}
