package mx.tc.j2se.tasks;

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

    /**
     * @param from
     * @param to
     */
    LinkedTaskList incoming(int from, int to);
}
