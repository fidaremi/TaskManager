package mx.tc.j2se.tasks;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 *
 */
public interface LinkedTaskList {

    /**
     * @param task
     */
    void add (Task task);

    /**
     * @param task
     */
    boolean remove (Task task);

    /**
     */
    int size();

    /**
     * @param index
     */
    Task getTask(int index);

    Iterator<Task> iterator();

    boolean equals(Object o);

    int hashCode();

    LinkedTaskListImpl clone();

    /**
     * This method returns a subset of tasks
     * that are scheduled for execution at least once after the "from" time,
     * and not later than the "to" time.
     * @param from is an argument which set the left bound of the time interval
     * @param to is an argument which set the right bound of the time interval
     * @return
     */
    LinkedTaskList incoming(int from, int to);

    public Stream<Task> getStream();
}
