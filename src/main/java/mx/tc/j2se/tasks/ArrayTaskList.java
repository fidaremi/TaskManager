package mx.tc.j2se.tasks;

/**
 * This interface defines the basic structure of array with tasks
 */
public interface ArrayTaskList {

    /**
     * This method adds a task to the array
     * @param task is an argument which set a task added to the array
     */
    void add (Task task);

    /**
     * This method removes a task from the array and returns true if the task
     * was in the array and was removed
     * @param task is an argument which set a task removed from the array
     * @return
     */
    boolean remove (Task task);

    /**
     * This method returns the array's size (quantity of elements)
     * @return
     */
    int size();

    /**
     * This method returns the array's element by its index
     * @param index is an argument which set the index of the task in the array
     * @return
     */
    Task getTask(int index);

    /**
     * This method returns a subset of tasks
     * that are scheduled for execution at least once after the "from" time,
     * and not later than the "to" time.
     * @param from is an argument which set the left bound of the time interval
     * @param to is an argument which set the right bound of the time interval
     * @return
     */
    ArrayTaskList incoming(int from, int to);
}
