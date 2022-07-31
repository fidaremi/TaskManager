package mx.tc.j2se.tasks;

import java.util.Arrays;

/**
 * This class allows to add a task to the array
 * Initial size of the array is 0
 */
public class ArrayTaskListImpl implements ArrayTaskList {
    private Task[] tasks = new Task[0];

    /**
     * This empty constructor constructs an array and doesn't set any properties
     */
    public ArrayTaskListImpl(){}

    /**
     * This method adds the specified task to the list
     * @param task is an argument which set a task added to the list
     */
    public void add(Task task) {
        if (task == null) {
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
     * @return
     */
    public boolean remove(Task task) {
        if (task != null) {
            for (int i = 0; i < tasks.length; i++) {
                if (tasks[i].equals(task)) {
                    Task[] removedTasks = new Task[tasks.length-1];
                    System.arraycopy(tasks, 0, removedTasks, 0, i);
                    System.arraycopy(tasks, i+1, removedTasks, i, tasks.length - i - 1);
                    tasks = removedTasks;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method returns the array's size (quantity of elements)
     * @return
     */
    public int size() {
        return tasks.length;
    }

    /**
     * This method returns a task which takes the specified place in the list
     * @param index is an argument which set the index of the task in the array
     * @return
     */
    public Task getTask(int index) {
        if (index >= tasks.length || index < 0) {
        }
        return tasks[index];
    }

    /**
     * This method returns a subset of tasks
     * that are scheduled for execution at least once after the "from" time,
     * and not later than the "to" time.
     * @param from is an argument which set the left bound of the time interval
     * @param to is an argument which set the right bound of the time interval
     * @return
     */
    public ArrayTaskList incoming(int from, int to) {
        ArrayTaskList incomingTasks = new ArrayTaskListImpl();
        if (to > from) {
            for (int i = 0; i < tasks.length; i++) {
                if (getTask(i).isActive() && getTask(i).nextTimeAfter(from) > from &&
                        getTask(i).nextTimeAfter(from) < to) {
                    incomingTasks.add(getTask(i));
                }
            }
        } return incomingTasks;
    }

    /**
     * This method returns array's members as a list of string values
     * @return
     */
    @Override
    public String toString() {
        return "ArrayTaskListImpl{" +
                "tasks=" + Arrays.toString(tasks) +
                '}';
    }
}

