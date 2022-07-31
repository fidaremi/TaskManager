package mx.tc.j2se.tasks.tests;

import mx.tc.j2se.tasks.ArrayTaskList;
import mx.tc.j2se.tasks.ArrayTaskListImpl;
import mx.tc.j2se.tasks.TaskImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskArrayTest {
    @Test
    public void TaskAdd() {
        ArrayTaskList tasks = new ArrayTaskListImpl();
        TaskImpl ActiveTask = new TaskImpl("Active Task", 10);
        tasks.add(ActiveTask);
        TaskImpl ActiveRepeated = new TaskImpl("Active Repeated", 10, 80, 5);
        tasks.add(ActiveRepeated);
        TaskImpl task2 = new TaskImpl("Active Repeated", 11, 81, 5);
        assertEquals(2, tasks.size());
        assertEquals(ActiveTask, tasks.getTask(0));
        assertEquals(ActiveRepeated, tasks.getTask(1));
        assertFalse(tasks.remove(task2));
        }

    @Test
    public void TaskRemove() {
        ArrayTaskList tasks = new ArrayTaskListImpl();
        TaskImpl ActiveTask = new TaskImpl("Active Task", 10);
        tasks.add(ActiveTask);
        TaskImpl ActiveRepeated = new TaskImpl("Active Repeated", 10, 80, 5);
        tasks.add(ActiveRepeated);
        TaskImpl ActiveRepeated2 = new TaskImpl("Active Repeated2", 11, 81, 5);
        tasks.add(ActiveRepeated2);
        assertTrue(tasks.remove(ActiveTask));
        assertTrue(tasks.remove(ActiveRepeated2));
        assertEquals(1, tasks.size());
        assertEquals(ActiveRepeated,tasks.getTask(0));
        tasks.add(ActiveTask);
        tasks.add(ActiveRepeated2);
        assertEquals(3, tasks.size());
        }

}