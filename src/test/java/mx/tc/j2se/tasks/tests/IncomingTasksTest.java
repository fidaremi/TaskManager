package mx.tc.j2se.tasks.tests;

import mx.tc.j2se.tasks.ArrayTaskList;
import mx.tc.j2se.tasks.ArrayTaskListImpl;
import mx.tc.j2se.tasks.TaskImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IncomingTasksTest {

    ArrayTaskList tasks;

    @Before
    public void beforeEach() {
        tasks = new ArrayTaskListImpl();
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
    }

    @Test
    public void IncomingTaskInTimeFrame() {
        ArrayTaskList incomingTasks = tasks.incoming(9, 35);
        assertEquals(3, incomingTasks.size());
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

    @Test
    public void IncomingTaskNonRepetitive() {
        ArrayTaskList tasks = new ArrayTaskListImpl();
        TaskImpl ActiveTask = new TaskImpl("Active Task", 10);
        ActiveTask.setActive(true);
        tasks.add(ActiveTask);
        TaskImpl ActiveRepeated = new TaskImpl("Active Repeated", 11, 31, 10);
        ActiveRepeated.setActive(true);
        ActiveRepeated.isRepeated();
        tasks.add(ActiveRepeated);
        TaskImpl ActiveRepeated2 = new TaskImpl("Active Repeated2", 12, 42, 10);
        ActiveRepeated2.setActive(true);
        ActiveRepeated2.isRepeated();
        tasks.add(ActiveRepeated2);
        assertEquals(1, tasks.incoming(9,11).size());
    }
}
