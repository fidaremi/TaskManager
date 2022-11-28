package mx.tc.j2se.tasks.tests;

import mx.tc.j2se.tasks.TaskImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EqualsAndHashCode {
    @Test
    public void nonRepeatedToRepeated() {
        TaskImpl Repeated = new TaskImpl("Test", 861);
        assertEquals(false, Repeated.isActive());
        assertEquals(false, Repeated.isRepeated());
        assertEquals(861, Repeated.getTime());
        assertEquals(861, Repeated.getEndTime());
        assertEquals(861, Repeated.getStartTime());
        assertEquals(0, Repeated.getRepeatInterval());
        assertEquals(-1, Repeated.nextTimeAfter(0));
        Repeated.setTime(179, 286, 2);
        assertEquals(179, Repeated.getTime());
        Repeated.setTime(861);
        assertEquals(861, Repeated.getTime());



    }
}
