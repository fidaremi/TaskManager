package mx.tc.j2se.tasks;

/**
 * This interface defines the basic structure and parameters of the task
 */
public interface Task {

    /**
     * This method returns the tasks title
     * @return
     */
    String getTitle();

    /**
     * This method sets the tasks title
     * @param title is the argument which sets a tasks title
     */
    void setTitle(String title);

    /**
     * This method returns the task's status
     * @return
     */
    boolean isActive();

    /**
     * This method set the task's status to active
     * @param active
     */
    void setActive(boolean active);

    /**
     * This method returns a start time of the non-repetitive task
     * @return
     */
    int getTime();

    /**
     * This method sets a start time of the non-repetitive task
     * @param time is the argument which sets a start time of non-repetitive task
     */
    void setTime(int time);

    /**
     * This method returns a start time of the repetitive task
     * @return
     */
    int getStartTime();

    /**
     * This method returns end time of the repetitive task
     * @return
     */
    int getEndTime();

    /**
     * This method returns an interval of repetition of the repetitive task
     * @return
     */
    int getRepeatInterval();

    /**
     * This method set the start time, end time and the interval of repetition
     * for the repetitive task
     * @param start is the argument which sets start time of repetitive task
     * @param end is the argument which sets end time of repetitive task
     * @param interval is the argument which sets interval for task repetition
     */
    void setTime(int start, int end, int interval);

    /**
     * This method returns true if the task it repetitive and false if
     * the task is not repetitive
     * @return
     */
    boolean isRepeated();

    /**
     * Returns the next task execution time after the current time, if after
     * the specified time the task won't be executed anymore, it returns -1.
     * @param current is the argument which set the current time
     * @return
     */
    int nextTimeAfter (int current);

}
