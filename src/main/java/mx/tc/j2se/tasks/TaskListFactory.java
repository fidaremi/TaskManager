package mx.tc.j2se.tasks;

/**
 * Class-name: TaskListFactory
 * This class implements basic of an abstract factory pattern
 * It has a TaskListFactory method which returns
 * the object of ArrayTaskListImpl or LinkedTaskListImpl class
 *
 * @version info: 0.1 26 September 2022
 * @author Mariia Kuntsevych
 * Copyright notice: freeware
 */
public class TaskListFactory {

    /**
     * This method, according to the type parameter,
     * returns the object of ArrayTaskListImpl or LinkedTaskListImpl class
     * @param type
     */
    public static AbstractTaskList createTaskList(ListTypes.types type) {
        return type.equals(ListTypes.types.ARRAY)
                ? new ArrayTaskListImpl()
                : new LinkedTaskListImpl();
//        if (type.equals(ListTypes.types.ARRAY)){
//            return new ArrayTaskListImpl();
//        } else {
//          return new LinkedTaskListImpl();
//        }
    }
}
