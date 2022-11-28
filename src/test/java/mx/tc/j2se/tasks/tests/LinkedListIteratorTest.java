package mx.tc.j2se.tasks.tests;

import mx.tc.j2se.tasks.LinkedTaskListImpl;
import mx.tc.j2se.tasks.Task;
import mx.tc.j2se.tasks.TaskImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LinkedListIteratorTest {
    LinkedTaskListImpl tasks1 = new LinkedTaskListImpl();
    TaskImpl ActiveTask = new TaskImpl("Active Task", 10);
    TaskImpl ActiveRepeated = new TaskImpl("Active Repeated", 10, 30, 10);
    TaskImpl ActiveRepeated2 = new TaskImpl("Active Repeated2", 11, 41, 10);

    @Before
    public void beforeEach() {
        tasks1 = new LinkedTaskListImpl();
        tasks1.add(ActiveTask);
        tasks1.add(ActiveRepeated);
        tasks1.add(ActiveRepeated2);
    }

    @Test
    public void LinkedListEquals() {
        assertEquals(3, tasks1.size());
        LinkedTaskListImpl tasks2 = new LinkedTaskListImpl();
        tasks2.add(ActiveTask);
        tasks2.add(ActiveRepeated);
        tasks2.add(ActiveRepeated2);
        assertEquals(tasks2, tasks1);
        assertEquals(tasks1.hashCode(), tasks2.hashCode());

    }

    @Test
    public void LinkedListNotEquals() {
        LinkedTaskListImpl tasks3 = new LinkedTaskListImpl();
        tasks3.add(ActiveTask);
        tasks3.add(ActiveRepeated);
        assertNotEquals(tasks3, tasks1);

        tasks3.add(ActiveRepeated);
        assertNotEquals(tasks3, tasks1);
        assertNotEquals(tasks1.hashCode(), tasks3.hashCode());

    }

    @Test
    public void LinkedListClone() {
        LinkedTaskListImpl tasks4 = tasks1.clone();
        assertEquals(tasks4, tasks1);
        tasks4.remove(ActiveRepeated);
        assertNotEquals(tasks4, tasks1);
    }

    @Test
    public void LinkedListIterator() {
        Iterator<Task> iterator = tasks1.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals(ActiveTask, iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals(ActiveRepeated, iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals(ActiveRepeated2, iterator.next());
        assertEquals(false, iterator.hasNext());
    }
}
