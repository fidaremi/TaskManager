package mx.tc.j2se.tasks.tests;

import mx.tc.j2se.tasks.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LinkedTaskListImplTest {

    AbstractTaskList tasks = TaskListFactory.createTaskList(ListTypes.types.LINKED);
//    LinkedTaskListImpl tasks = new LinkedTaskListImpl();
    TaskImpl ActiveTask = new TaskImpl("Active Task", 10);
    TaskImpl ActiveRepeated = new TaskImpl("Active Repeated", 10, 30, 10);
    TaskImpl ActiveRepeated2 = new TaskImpl("Active Repeated2", 11, 41, 10);

    @Before
    public void beforeEach() {
        ActiveTask.setActive(true);
        tasks.add(ActiveTask);
        ActiveRepeated.setActive(true);
        tasks.add(ActiveRepeated);
        ActiveRepeated2.setActive(true);
        tasks.add(ActiveRepeated2);
        System.out.println(tasks);
    }

    @Test
    public void add() {
        tasks.add(ActiveTask);
        tasks.add(ActiveRepeated);
        tasks.add(ActiveRepeated2);
        System.out.println(tasks);
    }

    @Test
    public void remove() {
        tasks.remove(ActiveTask);
        tasks.remove(ActiveRepeated);
        tasks.remove(ActiveRepeated2);
        System.out.println(tasks);
    }

    @Test
    public void size() {
        assertEquals(3, tasks.size());
        tasks.remove(ActiveTask);
        assertEquals(2, tasks.size());
        tasks.add(ActiveRepeated2);
        tasks.add(ActiveRepeated2);
        assertEquals(4, tasks.size());
    }

    @Test
    public void getTask() {
        assertEquals(ActiveTask, tasks.getTask(0));
        assertEquals(ActiveRepeated, tasks.getTask(1));
        assertEquals(ActiveRepeated2, tasks.getTask(2));
        try {
            tasks.getTask(3);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            tasks.getTask(-1);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
    }

    @Test
    public void IncomingTaskInTimeFrame() {
        AbstractTaskList incomingTasks = tasks.incoming(9, 45);
//        LinkedTaskList incomingTasks = tasks.incoming(9, 45);
        assertEquals(3, incomingTasks.size());
        System.out.println(incomingTasks);
        assertEquals(incomingTasks.getTask(0), tasks.getTask(0));
        assertEquals(incomingTasks.getTask(1), tasks.getTask(1));
        assertEquals(incomingTasks.getTask(2), tasks.getTask(2));
    }

    @Test
    public void IncomingTaskNotInTimeFrame() {
        assertEquals(0, tasks.incoming(22,29).size());
    }

    @Test
    public void IncomingTaskOverlapping() {
        assertEquals(1, tasks.incoming(10,20).size());
        assertEquals(ActiveRepeated2, tasks.incoming(10,20).getTask(0));
    }

    @Test
    public void IncomingTaskRepetitive() {
        assertEquals(2, tasks.incoming(18,42).size());
    }

    @Test
    public void IncomingTaskNonRepetitive() {
        ActiveRepeated.setTime(11, 31, 10);
        ActiveRepeated2.setTime(12, 42, 10);
        assertEquals(1, tasks.incoming(9,11).size());
    }

    @Test
    public void printToStringTest() {
        System.out.println(tasks.toString());
    }

    @Test
    public void iterator() {
        Iterator<Task> iterator = tasks.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals(ActiveTask, iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals(ActiveRepeated, iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals(ActiveRepeated2, iterator.next());
        assertEquals(false, iterator.hasNext());
        try {
            assertEquals(null, iterator.next());
        } catch (Exception e) {
            System.out.println("NoSuchElementException => " + e.getMessage());
        }
    }

    @Test
    public void testHashCode() {
        System.out.println(tasks.hashCode());
    }

    @Test
    public void testNonEqualHashCode() {
        AbstractTaskList tasks2 = TaskListFactory.createTaskList(ListTypes.types.LINKED);
//        LinkedTaskListImpl tasks2 = new LinkedTaskListImpl();
        tasks2.add(ActiveRepeated);
        tasks2.add(ActiveTask);
        tasks2.add(ActiveRepeated);
        System.out.println(tasks2.hashCode());
        assertNotEquals(tasks2.hashCode(), tasks.hashCode());
    }

    @Test
    public void testEqualHashCode() {
        AbstractTaskList tasks3 = TaskListFactory.createTaskList(ListTypes.types.LINKED);
//        LinkedTaskListImpl tasks3 = new LinkedTaskListImpl();
        tasks3.add(ActiveTask);
        tasks3.add(ActiveRepeated);
        tasks3.add(ActiveRepeated2);
        System.out.println(tasks3.hashCode());
        assertEquals(tasks3.hashCode(), tasks.hashCode());
    }

    @Test
    public void testNonEqual() {
        AbstractTaskList tasks2 = TaskListFactory.createTaskList(ListTypes.types.LINKED);
//        LinkedTaskListImpl tasks2 = new LinkedTaskListImpl();
        tasks2.add(ActiveRepeated);
        tasks2.add(ActiveTask);
        tasks2.add(ActiveRepeated);
        assertNotEquals(tasks2, tasks);
    }

    @Test
    public void testEqual() {
        AbstractTaskList tasks3 = TaskListFactory.createTaskList(ListTypes.types.LINKED);
//        LinkedTaskListImpl tasks3 = new LinkedTaskListImpl();
        tasks3.add(ActiveTask);
        tasks3.add(ActiveRepeated);
        tasks3.add(ActiveRepeated2);
        System.out.println(tasks3.hashCode());
        assertEquals(tasks3, tasks);
    }

    @Test
    public void testClone() {
        AbstractTaskList tasks4 = ((LinkedTaskListImpl) tasks).clone();
//        LinkedTaskListImpl tasks4 = new LinkedTaskListImpl();
        assertEquals(tasks4, tasks);
        assertEquals(tasks4.hashCode(), tasks.hashCode());
    }

    @Test
    public void testStream() {
        AbstractTaskList task5 = TaskListFactory.createTaskList(ListTypes.types.LINKED);
        tasks.getStream().filter(s -> s.getTitle() == "Active Task").forEach((task5::add));
        assertEquals(tasks.getTask(0), task5.getTask(0));}

    @Test
    public void testExceptionMessage() {
        AbstractTaskList tasks3 = TaskListFactory.createTaskList(ListTypes.types.LINKED);
        assertEquals(tasks3.size(), 0);
        try {
            tasks3.getStream();
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
            assertEquals("List cannot be empty", e.getMessage());
        }
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testIllegalArgumentException()
    { AbstractTaskList tasks3 = TaskListFactory.createTaskList(ListTypes.types.LINKED);
        tasks3.getStream();
    }
}
