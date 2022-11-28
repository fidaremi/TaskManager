package mx.tc.j2se.tasks;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

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
public class LinkedTaskListImpl /*extends AbstractTaskList*/ implements LinkedTaskList, Cloneable {
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
     private class Node {
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

//    /**
//     * This method returns a subset of tasks
//     * that are scheduled for execution at least once after the "from" time,
//     * and not later than the "to" time.
//     * @param from is an argument which set the left bound of the time interval
//     * @param to is an argument which set the right bound of the time interval
//     */
//    @Override
//    public AbstractTaskList incoming(int from, int to) {
//        LinkedTaskListImpl incomingTasks = new LinkedTaskListImpl();
//            if (from < 0 || to <= 0) {
//                throw new IllegalArgumentException("From and to values cannot be negative or 0");
//            }
//        if (to > from) {
//            for (int i = 0; i < size; i++) {
//                if (getTask(i).nextTimeAfter(from) > from &&
//                        getTask(i).nextTimeAfter(from) < to) {
//                    incomingTasks.add(getTask(i));
//                }
//            }
//        } return incomingTasks;
//    }

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

    /**
     * The method iterates over the elements of the task list and returns the values(iterators)
     * @return iterator
     */
    @Override
    public Iterator<Task> iterator() {
        return new Iterator<Task>() {
            Task task;
            Node iterator = new Node(task);
            Node tasksList = first;

            /**
             * Returns true if next would return an element rather than throwing an exception
             *
             * @return true if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                if (tasksList != null) {
                    return true;
                }
                return false;
            }

            /**
             * @return the next element in the iteration
             * Throws:
             * NoSuchElementException – if the iteration has no more elements
             */
            @Override
            public Task next() {
                if (tasksList == null) {
                    throw new NoSuchElementException("There is no next element in the list");
                } else {
                        iterator = tasksList;
                        tasksList = tasksList.next;
                    return iterator.task;
                }
            }
        };
    }

    /**
     * Returns the hash code value for LinkedTaskListImpl.
     *
     * <p>This implementation uses exactly the code that is used to define the
     * list hash function in the documentation for the {@link List#hashCode}
     * method.
     *
     * @return the hash code value for this list
     */
    @Override
    public int hashCode() {
        int hashCode = 1;
        for (Node tasksList = first; tasksList!=null; tasksList = tasksList.next)
            hashCode = 31*hashCode + (tasksList==null ? 0 : tasksList.task.hashCode());
        return hashCode;
    }

    /**
     * This method compares two lists of tasks and consider them as equal
     * if the both lists contain the same tasks in the same order
     * @param o is an objects what we are comparing with a list of tasks
     * @return boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LinkedTaskListImpl)) {
            return false;
        }
        LinkedTaskListImpl linkedTaskList = (LinkedTaskListImpl) o;

        if (this.size() == linkedTaskList.size()) {
            Node obj = this.first;
            Node e = linkedTaskList.first;
            while (obj.next != null && e.next != null) {
                    obj = obj.next;
                    e = e.next;

                   if (!obj.task.equals(e.task)) {
                       return false;
                }
            } return true;
        } return false;
        }

    /**
     * @return close of the LinkedTaskListImpl object
     */
    @Override
    public LinkedTaskListImpl clone()
    {
        try {
            return (LinkedTaskListImpl) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
