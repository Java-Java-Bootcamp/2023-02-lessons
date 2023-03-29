import org.example.TaskManger;
import org.example.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class TaskManagerTest {
    private TaskManger manger;
    private Task task;

    @BeforeEach
    public void prepare() {
        manger = new TaskManger();
        task = new Task();
        task.setDateTime(LocalDateTime.of(2023, 3, 28, 11, 30));
    }

    @Test
    void testAddTask() {
        manger.add(task);

        List<Task> tasks = manger.get();
        Assertions.assertNotNull(tasks);
        Assertions.assertEquals(1, tasks.size());
        Assertions.assertEquals(tasks.get(0), task);
    }

    @Test
    public void testDeleteTask() {
        // prepare
        manger.add(task);

        // actions
        manger.delete(task);

        // assertions
        List<Task> tasks = manger.get();
        Assertions.assertNotNull(tasks);
        Assertions.assertTrue(tasks.isEmpty());
    }
}
