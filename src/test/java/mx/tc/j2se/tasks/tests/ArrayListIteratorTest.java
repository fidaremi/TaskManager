package mx.tc.j2se.tasks.tests;

import mx.tc.j2se.tasks.*;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ArrayListIteratorTest {

       /*    void test() {
*//*        AbstractTaskList list = TaskListFactory.createTaskList(ListTypes.types.LINKED);
        for(Task task : list) {

        }
    }*/
    @Test
    public void Tasks() {
        ArrayTaskListImpl tasks1 = new ArrayTaskListImpl();
        TaskImpl ActiveTask = new TaskImpl("Active Task", 10);
        tasks1.add(ActiveTask);
        TaskImpl ActiveRepeated = new TaskImpl("Active Repeated", 10, 30, 10);
        tasks1.add(ActiveRepeated);
        TaskImpl ActiveRepeated3 = new TaskImpl("Active Repeated3", 11, 41, 10);
        tasks1.add(ActiveRepeated3);
        ArrayTaskListImpl tasks2 = tasks1.clone();
        assertEquals(tasks2.hashCode(), tasks1.hashCode());

        tasks2.remove(ActiveRepeated);
        tasks2.add(ActiveRepeated3);
        assertNotEquals(tasks1, tasks2);

        ArrayTaskListImpl tasks3 = new ArrayTaskListImpl();
        tasks3.add(ActiveTask);
        tasks3.add(ActiveRepeated);
        tasks3.add(ActiveRepeated3);
        assertEquals(tasks3.hashCode(), tasks1.hashCode());
        assertEquals(tasks3, tasks1);

        ArrayTaskListImpl tasks4 = new ArrayTaskListImpl();
        tasks4.add(ActiveRepeated3);
        tasks4.add(ActiveTask);
        tasks4.add(ActiveRepeated);
        assertNotEquals(tasks4.hashCode(), tasks3.hashCode());
        assertNotEquals(tasks4, tasks3);

        Iterator<Task> iterator = tasks4.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals(ActiveRepeated3, iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals(ActiveTask, iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals(ActiveRepeated, iterator.next());
        assertEquals(3, tasks4.size());
        assertEquals(false, iterator.hasNext());
        assertEquals(null, iterator.next());

    }


}
