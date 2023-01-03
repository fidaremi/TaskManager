package mx.tc.j2se.tasks.tests;

import mx.tc.j2se.tasks.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskListFactoryTest {
        @Test
        public void ArrayTaskListImpl() {
        AbstractTaskList test1 = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
        assertTrue(test1 instanceof ArrayTaskListImpl);
        AbstractTaskList test2 = TaskListFactory.createTaskList(ListTypes.types.LINKED);
        assertTrue(test2 instanceof LinkedTaskListImpl);
}
}

