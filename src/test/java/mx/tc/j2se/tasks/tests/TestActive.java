package mx.tc.j2se.tasks.tests;

import mx.tc.j2se.tasks.TaskImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestActive {
    @Test
    public void nextTimeAfterActiveNonRepeated() {
        TaskImpl ActiveTask = new TaskImpl("Active Task", 10);
        ActiveTask.setActive(true);
        assertEquals(10, ActiveTask.nextTimeAfter(5));
        assertEquals(-1, ActiveTask.nextTimeAfter(10));
        assertEquals(0, ActiveTask.getRepeatInterval());
        }

    @Test
    public void nextTimeAfterActiveRepeated() {
        TaskImpl ActiveRepeated = new TaskImpl("Active Repeated", 10, 80, 5);
        ActiveRepeated.setActive(true);
        ActiveRepeated.isRepeated();
        assertEquals(15, ActiveRepeated.nextTimeAfter(10));
        assertEquals(-1, ActiveRepeated.nextTimeAfter(80));
        assertEquals(-1, ActiveRepeated.nextTimeAfter(85));
        assertEquals(10, ActiveRepeated.nextTimeAfter(4));
        assertEquals(15, ActiveRepeated.nextTimeAfter(10));
        assertEquals(40, ActiveRepeated.nextTimeAfter(37));
        assertEquals(75, ActiveRepeated.nextTimeAfter(74));
        assertEquals(-1, ActiveRepeated.nextTimeAfter(75));
        assertEquals(-1, ActiveRepeated.nextTimeAfter(80));
        }

    @Test
    public void nextTimeAfterRepeatedToNonRepeated() {
        TaskImpl ToNonRepeated = new TaskImpl("Active Repeated", 1, 100, 24);
        ToNonRepeated.setActive(true);
        ToNonRepeated.setTime(89);
        assertFalse(ToNonRepeated.isRepeated());
        assertEquals(89, ToNonRepeated.getTime());
    }

    @Test
    public void nextTimeAfterInactive() {
        TaskImpl InactiveTask = new TaskImpl("Active Task", 10);
        InactiveTask.setActive(false);
    }

    @Test
    public void nextTimeAfterActiveRepeatedGetStart() {
        TaskImpl ActiveRepeated = new TaskImpl("Active Repeated", 5, 15, 2);
        ActiveRepeated.isActive();
        ActiveRepeated.isRepeated();
        assertEquals(5, ActiveRepeated.getTime());
    }

    @Test
    public void nextTimeAfterActiveRepeatedToInactive() {
        TaskImpl ActiveRepeated = new TaskImpl("Active Repeated", 5, 15, 2);
        ActiveRepeated.isActive();
        ActiveRepeated.isRepeated();
        ActiveRepeated.setTime(10);
        assertEquals(10, ActiveRepeated.getTime());
    }

    @Test
    public void nonRepeatedToRepeated () {
        TaskImpl ActiveNonRepeated = new TaskImpl("Non Repeated", 10);
        ActiveNonRepeated.setTime(10, 100, 24);
        ActiveNonRepeated.setActive(true);
        assertEquals(true, ActiveNonRepeated.isActive());
        assertEquals(true, ActiveNonRepeated.isRepeated());
        assertEquals(10, ActiveNonRepeated.getStartTime());
        assertEquals(100, ActiveNonRepeated.getEndTime());
        assertEquals(24, ActiveNonRepeated.getRepeatInterval());
        assertEquals(10, ActiveNonRepeated.nextTimeAfter(5));

    }
}
