package mx.tc.j2se.tasks;

import java.util.Iterator;

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
     * @param from
     * @param to
     */
    LinkedTaskList incoming(int from, int to);
}
