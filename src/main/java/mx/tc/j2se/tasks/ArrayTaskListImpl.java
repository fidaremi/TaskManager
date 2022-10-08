package mx.tc.j2se.tasks;

import java.util.Arrays;

/**
 * Class name: ArrayTaskListImpl
 * This class allows to add a task to the array
 * Initial size of the array is 0
 */
public class ArrayTaskListImpl extends AbstractTaskList {
    private Task[] tasks = new Task[0];
    /**
     * This empty constructor constructs an array and doesn't set any properties
     */
    public ArrayTaskListImpl(){}

    /**
     * This method adds the specified task to the list
     * @param task is an argument which set a task added to the list
     */
    @Override public void add(Task task) {
        try {
            if (task == null) {
                throw new NullPointerException("Task cannot be null");
            }
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException => " + e.getMessage());

        }
        Task[] addedTasks = new Task[tasks.length + 1];
        System.arraycopy(tasks, 0, addedTasks, 0, tasks.length);
        addedTasks[addedTasks.length - 1] = task;
        tasks = addedTasks;
    }

    /**
     * This method removes the specified task to the list
     * and returns true, if such a task was in the list
     * @param task is an argument which set a task removed from the list
     */
    @Override public boolean remove(Task task) {
        if (task == null) {
                throw new NullPointerException("Task cannot be null");
            }
        for (int i = 0; i < tasks.length; i++) {
                if (tasks[i].equals(task)) {
                    Task[] removedTasks = new Task[tasks.length-1];
                    System.arraycopy(tasks, 0, removedTasks, 0, i);
                    System.arraycopy(tasks, i+1, removedTasks, i, tasks.length - i - 1);
                    tasks = removedTasks;
                    return true;
                }
            }
        return false;
    }

    /**
     * This method returns the array's size (quantity of elements)
     */
    @Override public int size() {
        return tasks.length;
    }

    /**
     * This method returns a task which takes the specified place in the list
     * @param index is an argument which set the index of the task in the array
     */
    @Override public Task getTask(int index) {
        if (index >= tasks.length || index < 0) {
                throw new IndexOutOfBoundsException("Provided index exceeds the permissible limits for the " +
                        "list or is a negative value");
            }
        return tasks[index];
    }

    /**
     * This method returns a subset of tasks
     * that are scheduled for execution at least once after the "from" time,
     * and not later than the "to" time.
     * @param from is an argument which set the left bound of the time interval
     * @param to is an argument which set the right bound of the time interval
     */
    @Override public AbstractTaskList incoming(int from, int to) {
        ArrayTaskListImpl incomingTasks = new ArrayTaskListImpl();
        if (from < 0 || to <= 0) {
                throw new IllegalArgumentException("From and to values cannot be negative or 0");
            }
        if (to > from) {
            for (int i = 0; i < tasks.length; i++) {
                if (getTask(i).nextTimeAfter(from) > from &&
                        getTask(i).nextTimeAfter(from) < to) {
                    incomingTasks.add(getTask(i));
                }
            }
        } return incomingTasks;
    }

    /**
     * This method returns array's members as a list of string values
     */
    @Override
    public String toString() {
        return "ArrayTaskListImpl{" +
                "tasks=" + Arrays.toString(tasks) +
                '}';
    }
}

