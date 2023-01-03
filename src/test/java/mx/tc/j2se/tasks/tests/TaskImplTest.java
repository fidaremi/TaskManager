package mx.tc.j2se.tasks.tests;

import mx.tc.j2se.tasks.TaskImpl;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskImplTest {

    TaskImpl taskNonRepeated = new TaskImpl("TaskNonRepeated", 10);
    TaskImpl taskRepeated = new TaskImpl("Task Repeated", 10, 80, 5);

    @Test
    public void exceptionsInvalidNonRepeated () {
        try {
            TaskImpl nonRepeated = new TaskImpl(null, 1);
        } catch (Exception e) {
            System.out.println("NullPointerException => " + e.getMessage());
        }
        try {
            TaskImpl nonRepeated1 = new TaskImpl("Non Repeated", -1);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            TaskImpl nonRepeated2 = new TaskImpl("Non Repeated", 0);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
    }

    @Test
    public void exceptionsInvalidRepeated() {
        try {
            TaskImpl repeated = new TaskImpl(null, 10, 20, 5);
        } catch (Exception e) {
            System.out.println("NullPointerException => " + e.getMessage());
        }
        try {
            TaskImpl Repeated1 = new TaskImpl("Repeated", -1, 2, 1);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            TaskImpl Repeated2 = new TaskImpl("Repeated", 0, 2, 1);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            TaskImpl Repeated3 = new TaskImpl("Repeated", 1, 0, 1);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            TaskImpl Repeated4 = new TaskImpl("Repeated", 1, -1, 1);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            TaskImpl Repeated3 = new TaskImpl("Repeated", 2, 1, 1);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            TaskImpl Repeated4 = new TaskImpl("Repeated", 1, 1, 1);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            TaskImpl Repeated5 = new TaskImpl("Repeated", 1, 2, 0);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            TaskImpl Repeated6 = new TaskImpl("Repeated", 1, 2, -1);
        } catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
    }

    @Test
    public void getTitle() {
        assertEquals("TaskNonRepeated", taskNonRepeated.getTitle());
        assertEquals("Task Repeated", taskRepeated.getTitle());
    }

    @Test
    public void setTitle() {
        taskNonRepeated.setTitle("Renamed TaskNonRepeated");
        taskRepeated.setTitle("Renamed Task Repeated");
        assertEquals("Renamed TaskNonRepeated", taskNonRepeated.getTitle());
        assertEquals("Renamed Task Repeated", taskRepeated.getTitle());
    }

    @Test
    public void exceptionsSetInvalidTitle () {
        try {
            taskNonRepeated.setTitle(null);
        } catch (Exception e) {
            System.out.println("NullPointerException => " + e.getMessage());
        }
        try {
            taskRepeated.setTitle(null);
        } catch (Exception e) {
            System.out.println("NullPointerException => " + e.getMessage());
        }
    }

    @Test
    public void isActive() {
        assertEquals(false, taskNonRepeated.isActive());
        assertEquals(false, taskRepeated.isActive());
    }

    @Test
    public void setActive() {
        taskNonRepeated.setActive(true);
        taskRepeated.setActive(true);
        assertEquals(true, taskNonRepeated.isActive());
        assertEquals(true, taskRepeated.isActive());
    }

    @Test
    public void getTime() {
        assertEquals(10, taskNonRepeated.getTime());
        assertEquals(10, taskRepeated.getTime());
    }

    @Test
    public void setTime() {
        taskNonRepeated.setTime(20);
        taskRepeated.setTime(20);
        assertEquals(20, taskNonRepeated.getTime());
        assertEquals(20, taskRepeated.getTime());
        assertEquals(false, taskRepeated.isRepeated());
    }

    @Test
    public void exceptionsSetInvalidTimeForNonRepeated() {
        try {taskRepeated.setTime(0);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskRepeated.setTime(-1);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskRepeated.setTime(0);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskRepeated.setTime(-1);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
    }

    @Test
    public void getStartTime() {
        assertEquals(10, taskNonRepeated.getStartTime());
        assertEquals(10, taskRepeated.getStartTime());
    }

    @Test
    public void getEndTime() {
        assertEquals(10, taskNonRepeated.getEndTime());
        assertEquals(80, taskRepeated.getEndTime());
    }

    @Test
    public void getRepeatInterval() {
        assertEquals(0, taskNonRepeated.getRepeatInterval());
        assertEquals(5, taskRepeated.getRepeatInterval());
    }

    @Test
    public void setTimeForRepeated() {
        taskNonRepeated.setTime(20, 100, 10);
        assertEquals(false, taskNonRepeated.isActive());
        assertEquals(10, taskNonRepeated.getRepeatInterval());
        assertEquals(20, taskNonRepeated.getStartTime());
        assertEquals(100, taskNonRepeated.getEndTime());

        taskRepeated.setTime(4, 80, 4);
        assertEquals(false, taskRepeated.isActive());
        assertEquals(4, taskRepeated.getRepeatInterval());
        assertEquals(4, taskRepeated.getStartTime());
        assertEquals(80, taskRepeated.getEndTime());
    }

    @Test
    public void exceptionsSetInvalidTimeForRepeated() {
        try {taskNonRepeated.setTime(0, 100, 10);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskNonRepeated.setTime(-1, 100, 10);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskNonRepeated.setTime(20, 0, 10);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskNonRepeated.setTime(20, -1, 10);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskNonRepeated.setTime(20, 20, 10);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskNonRepeated.setTime(20, 10, 10);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskNonRepeated.setTime(20, 200, -1);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskNonRepeated.setTime(20, 100, 0);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskRepeated.setTime(0, 100, 10);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskRepeated.setTime(-1, 100, 10);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskRepeated.setTime(20, 0, 10);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskRepeated.setTime(20, -1, 10);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskRepeated.setTime(20, 20, 10);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskRepeated.setTime(20, 10, 10);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskRepeated.setTime(20, 200, -1);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {taskRepeated.setTime(20, 100, 0);}
        catch (Exception e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
    }

    @Test
    public void isRepeated() {
        assertEquals(false, taskNonRepeated.isRepeated());
        assertEquals(true, taskRepeated.isRepeated());
    }

    @Test
    public void nextTimeAfterNonRepeated() {
        assertEquals(-1, taskNonRepeated.nextTimeAfter(5));
        taskNonRepeated.setActive(true);
        assertEquals(10, taskNonRepeated.nextTimeAfter(5));
        assertEquals(-1, taskNonRepeated.nextTimeAfter(10));
        assertEquals(-1, taskNonRepeated.nextTimeAfter(20));
        assertEquals(0, taskNonRepeated.getRepeatInterval());
    }

    @Test
    public void nextTimeAfterRepeated() {
        assertEquals(-1, taskRepeated.nextTimeAfter(10));
        taskRepeated.setActive(true);
        assertEquals(15, taskRepeated.nextTimeAfter(10));
        assertEquals(-1, taskRepeated.nextTimeAfter(80));
        assertEquals(-1, taskRepeated.nextTimeAfter(85));
        assertEquals(10, taskRepeated.nextTimeAfter(4));
        assertEquals(15, taskRepeated.nextTimeAfter(10));
        assertEquals(40, taskRepeated.nextTimeAfter(37));
        assertEquals(75, taskRepeated.nextTimeAfter(74));
        assertEquals(-1, taskRepeated.nextTimeAfter(75));
        assertEquals(-1, taskRepeated.nextTimeAfter(80));
    }

    @Test
    public void printToStringTest() {
        System.out.println(taskNonRepeated.toString());
        System.out.println(taskRepeated.toString());
    }

    @Test
    public void taskHashCode() {
        System.out.println(taskNonRepeated.hashCode());
        System.out.println(taskRepeated.hashCode());
        assertNotEquals(taskNonRepeated.hashCode(), taskRepeated.hashCode());
    }

    @Test
    public void taskEqualsNonRepeated() {
        assertNotEquals(taskNonRepeated, taskRepeated);

        TaskImpl taskNonRepeated2 = new TaskImpl("TaskNonRepeated", 10);
        assertEquals(taskNonRepeated, taskNonRepeated2);
        assertEquals(taskNonRepeated.hashCode(), taskNonRepeated2.hashCode());

        TaskImpl taskNonRepeated3 = new TaskImpl("TaskNonRepeated3", 10);
        assertNotEquals(taskNonRepeated, taskNonRepeated3);

        TaskImpl taskNonRepeated4 = new TaskImpl("TaskNonRepeated", 1);
        assertNotEquals(taskNonRepeated, taskNonRepeated4);

        taskNonRepeated4.setTime(10);
        assertEquals(taskNonRepeated, taskNonRepeated4);

        taskNonRepeated4.setActive(true);
        assertNotEquals(taskNonRepeated, taskNonRepeated4);

        taskNonRepeated4.setActive(false);
        assertEquals(taskNonRepeated.isRepeated(), taskNonRepeated4.isRepeated());

        assertEquals(taskNonRepeated.nextTimeAfter(5), taskNonRepeated4.nextTimeAfter(5));

    }

    @Test
    public void taskEqualsRepeated() {

        TaskImpl taskRepeated2 = new TaskImpl("Task Repeated", 10, 80, 5);
        assertEquals(taskRepeated, taskRepeated2);
        assertEquals(taskRepeated.hashCode(), taskRepeated2.hashCode());

        TaskImpl taskRepeated3 = new TaskImpl("Task Repeated3", 10, 80, 5);
        assertNotEquals(taskRepeated, taskRepeated3);

        TaskImpl taskRepeated4 = new TaskImpl("Task Repeated", 1, 80, 5);
        assertNotEquals(taskRepeated, taskRepeated4);

        TaskImpl taskRepeated5 = new TaskImpl("Task Repeated", 10, 20, 5);
        assertNotEquals(taskRepeated, taskRepeated5);

        TaskImpl taskRepeated6 = new TaskImpl("Task Repeated", 10, 80, 10);
        assertNotEquals(taskRepeated, taskRepeated6);

        taskRepeated6.setTime(10, 80, 5);
        assertEquals(taskRepeated, taskRepeated6);

        taskRepeated6.setActive(true);
        assertNotEquals(taskRepeated, taskRepeated6);

        taskRepeated6.setActive(false);
        assertEquals(taskRepeated.isRepeated(), taskRepeated6.isRepeated());

        assertEquals(taskRepeated.nextTimeAfter(5), taskRepeated4.nextTimeAfter(5));

    }

    @Test
    public void cloneTask() {
        TaskImpl taskNonRepeatedCloned = taskNonRepeated.clone();
        assertEquals(taskNonRepeated, taskNonRepeatedCloned);
        assertEquals(taskNonRepeated.hashCode(), taskNonRepeatedCloned.hashCode());

        TaskImpl taskRepeatedCloned = taskRepeated.clone();
        assertEquals(taskRepeated, taskRepeatedCloned);
        assertEquals(taskRepeated.hashCode(), taskRepeatedCloned.hashCode());
    }


    }
