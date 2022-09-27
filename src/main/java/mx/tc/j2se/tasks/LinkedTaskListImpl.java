package mx.tc.j2se.tasks;

/**
 * Class name: LinkedTaskListImpl
 * This class allows to add a task to the linked, it has
 * the same methods as ArrayTaskList and implements public interface  LinkedTaskList
 * Initial size of the lined list is 0
 *
 * @version info: 0.1 26 September 2022
 * @author Mariia Kuntsevych
 * Copyright notice: freeware
 */
public class LinkedTaskListImpl extends AbstractTaskList {
     private Node first;
     private Node last;
     private int size = 0;


    /**
     * This empty constructor constructs linked list and doesn't set any properties
     */
     public LinkedTaskListImpl() {
     }

    /**
     * This class creates the object Node which store task as an
     * element of the linked list
     * Variable task keeps a task as an element of the list
     * Variable next identify the next element of the list
     */
     private static class Node {
        Task task;
        Node next;

        /**
         * This method set input value into field task.
         * @param task is an argument which set a task added to the list
         */
        public Node (Task task) {
            this.task = task;
            }
        }

    /**
     * This method adds the specified task to the list
     * @param task task is an argument which set a task added to the list
     */
    @Override public void add(Task task) {
            if (task == null) {
                throw new IllegalArgumentException("Task cannot be empty");
            }
        Node addedTaskNode = new Node(task);
        if (last == null) {
            first = addedTaskNode;
            last = addedTaskNode;
            last.next = null;
        } else {
            last.next = addedTaskNode;
            last = addedTaskNode;
            }
        size++;
    }

    /**
     * This method adds the specified task to the list
     * @param task is an argument which set a task added to the list
     */
    @Override public boolean remove(Task task){
            if (task == null) {
                throw new IllegalArgumentException("Task cannot be empty");
            }
        Node removedTask = first;
        Node previous = null;
        while (removedTask != null) {
            if (removedTask.task.equals(task)) {
                if (previous == null){
                    first = first.next;
                    if (first == null) {
                        last = null;
                    }
                }else {
                    previous.next = removedTask.next;
                    if (removedTask.next == null) {
                        last = previous;
                    }
                }
                size--;
                return true;
            }
                previous = removedTask;
                removedTask = removedTask.next;
            }
        return false;
    }

    /**
     * This method returns the array's size (quantity of elements)
     */
    @Override public int size() {
        return size;
    }

    /**
     * This method returns a task which takes the specified place in the list
     * @param index is an argument which set the index of the task in the array
     */
    @Override public Task getTask(int index) {
            if (index >= size || index < 0) {
                throw new IndexOutOfBoundsException("Provided index exceeds the permissible limits for the " +
                        "list or is a negative value");
            }
        Node tasksList = first;
        for (int i = 0; i < index; i++) {
            tasksList = tasksList.next;
        }
        return tasksList.task;
    }

    /**
     * This method returns a subset of tasks
     * that are scheduled for execution at least once after the "from" time,
     * and not later than the "to" time.
     * @param from is an argument which set the left bound of the time interval
     * @param to is an argument which set the right bound of the time interval
     */
    @Override
    public AbstractTaskList incoming(int from, int to) {
        LinkedTaskListImpl incomingTasks = new LinkedTaskListImpl();
            if (from < 0 || to <= 0) {
                throw new IllegalArgumentException("From and to values cannot be negative or 0");
            }
        if (to > from) {
            for (int i = 0; i < size; i++) {
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
        return "LinkedTaskList{" +
                "start=" + first +
                ", end=" + last +
                ", length=" + size +
                '}';
    }

}
