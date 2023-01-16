package mx.tc.j2se.tasks;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Class-name: AbstractTaskList
 * This class describes operations,
 * which can be performed with the task list, and
 * implements the methods that do not depend on the saving method
 *
 * @version info: 0.1 26 September 2022
 * @author Mariia Kuntsevych
 * Copyright notice: freeware
 */
public abstract class AbstractTaskList implements Iterable<Task> {

        /**
         * This method adds a task to the array
         * @param task is an argument which set a task added to the array
         */
        public abstract void add(Task task);

        /**
         * This method removes a task from the array and returns true if the task
         * was in the array and was removed
         * @param task is an argument which set a task removed from the array
         * @return
         */
        public abstract boolean remove(Task task);

        /**
         * This method returns the array's size (quantity of elements)
         * @return
         */
        public abstract int size();

        /**
         * This method returns the array's element by its index
         * @param index is an argument which set the index of the task in the array
         * @return
         */
        public abstract Task getTask(int index);

        /**
         * This method returns a subset of tasks
         * that are scheduled for execution at least once after the "from" time,
         * and not later than the "to" time.
         * @param from is an argument which set the left bound of the time interval
         * @param to is an argument which set the right bound of the time interval
         * @return
         */
        public final AbstractTaskList incoming(int from, int to) {
                if (from < 0 || to <= 0) {
                      throw new IllegalArgumentException("From and to values cannot be negative or 0");
                }
                AbstractTaskList incomingTasks = TaskListFactory.returnListType(this);
                getStream().filter(task -> (from > 0 && to > 0
                                                && task.nextTimeAfter(from) > from
                                                && task.nextTimeAfter(from) < to)).forEach(incomingTasks::add);
//                if (to > from) {
//                        for (int i = 0; i < size(); i++) {
//                                if (getTask(i).nextTimeAfter(from) > from &&
//                                        getTask(i).nextTimeAfter(from) < to) {
//                                        incomingTasks.add(getTask(i));
//                                }
//                        }
//                }
                return incomingTasks;
        }

        /**
         * The method iterates over the elements of the task list and returns the values (iterators)
         * @return iterator
         */
        public abstract Iterator<Task> iterator();

        /**
         * @return a stream on the base of collection (LinkedList or ArrayList)
         */
        public abstract Stream<Task> getStream();

}



