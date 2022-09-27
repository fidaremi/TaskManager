package mx.tc.j2se.tasks.tests;

import mx.tc.j2se.tasks.LinkedTaskListImpl;
import mx.tc.j2se.tasks.TaskImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedTaskListTest {

    LinkedTaskListImpl tasks;

    @Before
    public void beforeEach() {
        tasks = new LinkedTaskListImpl();
        TaskImpl ActiveTask = new TaskImpl("Active Task", 10);
        ActiveTask.setActive(true);
        tasks.add(ActiveTask);
        TaskImpl ActiveRepeated = new TaskImpl("Active Repeated", 10, 30, 10);
        ActiveRepeated.setActive(true);
        ActiveRepeated.isRepeated();
        tasks.add(ActiveRepeated);
        TaskImpl ActiveRepeated2 = new TaskImpl("Active Repeated2", 11, 41, 10);
        ActiveRepeated2.setActive(true);
        ActiveRepeated2.isRepeated();
        tasks.add(ActiveRepeated2);
        tasks.remove(ActiveTask);
    }

    @Test
    public void size() {
        assertEquals(2, tasks.size());
    }

    @Test
    public void getTask() {
        assertEquals("Active Repeated", tasks.getTask(0).getTitle());
        System.out.println(tasks);
    }

    @Test
    public void IncomingTaskInTimeFrame() {
        LinkedTaskListImpl incomingTasks = (LinkedTaskListImpl) tasks.incoming(9, 35);
        assertEquals(2, incomingTasks.size());
        System.out.println(incomingTasks);
        assertEquals(incomingTasks.getTask(0), tasks.getTask(0));
    }

    @Test
    public void IncomingTaskNotInTimeFrame() {
        assertEquals(0, tasks.incoming(22,29).size());
    }

    @Test
    public void IncomingTaskOverlapping() {
        assertEquals(1, tasks.incoming(10,20).size());
    }
}
