package mx.tc.j2se.tasks;

/**
 * Classname: TaskImpl
 * This class implements task management functionality
 * through various constructor methods
 *
 * @version info: 0.1 20 June 2022
 * @author Mariia Kuntsevych
 * Copyright notice: freeware
 */

public class TaskImpl implements Task {

    private String title;
    private int time;
    private int start;
    private int end;
    private boolean active;
    private boolean repeated;
    private int interval;
    private int current;

    /**
     * This empty constructor doesn't set any properties
     */

    public TaskImpl() {
    };

    /**
     * This constructor constructs an inactive task to run at a specified time
     * without repeating with a given name
     */
    public TaskImpl(String title, int time) {
        this.active = false;
        this.title = title;
        this.repeated = false;
        this.time = time;
    }

    /**
     * This constructor constructs an inactive task to run within the specified time range
     * (including the start and the end time)
     * with the set repetition interval and with a given name
     */
    public TaskImpl(String title, int start, int end, int interval) {
        this.active = false;
        this.repeated = true;
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    /**
     * This method implements reading of the task name
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method implements setting of the task name
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method implements reading of the task status
     */
    public boolean isActive() {
        return active;
    }

    /**
     * This method implements setting of the task status
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * This method implements returning repetition start time of the task
     * if the task is a repetitive one and execution time is the task is
     * non-repetitive
     */
    public int getTime() {
        if (repeated == true) {
            return start;
        }
        return time;
    }

    /**
     * This method implements setting of
     */
    public void setTime(int time) {
        if (repeated == true) {
            repeated = false;
        }
       this.time = time;
    }

    /**
     * This method returns the start time of the execution
     */
    public int getStartTime() {
        if (repeated == false) {
            return time;
        }
        return start;
    }

    /**
     * This method returns the end time of the execution
     */
    public int getEndTime() {
        if (repeated == false) {
            return time;
        }
        return end;
    }

    /**
     * This method returns repeat interval for repetitive task and
     * returns 0 for non-repetitive
     */
    public int getRepeatInterval() {
        if (repeated == false) {
            return 0;
        }
        return interval;
    }

    /**
     * This method is setting start and end time of the repetitive tasks and
     * repeat interval for them
     */
    public void setTime(int start, int end, int interval) {
        this.start = start;
        this.interval = interval;
        this.end = end;
        this.repeated = true;
    }

    /**
     * This method is checking the task for repeatability
     */
    public boolean isRepeated() {
        return repeated;
    }

    /**
     * This method is checking the task for repeatability
     * and returns its next fire time.
     */
    public int nextTimeAfter (int current) {
        if (active && repeated == false) {
            if (current < time) {
                return time;
            }
            return -1;
        } else if (active && repeated) {
            if (current < start) {
                return start;
            } else if (current >= end) {
                return -1;
            }
            int nextTimeAfter = start;
            while (current >= nextTimeAfter && nextTimeAfter < end) {
                nextTimeAfter += interval;
            }
            if (current >= start && current < end && nextTimeAfter < end) {
                return nextTimeAfter;
            }
            return -1;
        }
        return -1;
    }
}
