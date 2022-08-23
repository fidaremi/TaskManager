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
     * This empty constructor constructs a task and doesn't set any properties
     */
    public TaskImpl() {
    }

    /**
     * This constructor constructs an inactive task to run at a specified time
     * without repeating with a given name
     * @param title is the argument which sets a tasks title
     * @param time is the argument which sets a start time of non-repetitive task
     */
    public TaskImpl(String title, int time) {
        try {
           if (time <= 0) { throw new IllegalArgumentException("Time value cannot be negative or 0");
           }
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
            }
        try {
            if (title == null) { throw new NullPointerException("Title value cannot be null");
            }
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException => " + e.getMessage());

        }
        this.active = false;
        this.title = title;
        this.repeated = false;
        this.time = time;
    }
    /**
     * This constructor constructs an inactive task to run within the specified time range
     * (including the start and the end time)
     * with the set repetition interval and with a given name
     * @param title is the argument which sets a tasks title
     * @param start is the argument which sets start time of repetitive task
     * @param end is the argument which sets end time of repetitive task
     * @param interval is the argument which sets interval for task repetition
     */
    public TaskImpl(String title, int start, int end, int interval) {
        try {
            if (start <= 0) {
                throw new IllegalArgumentException("Start time value cannot be negative or 0");
                }
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            if (end <= 0) {
                throw new IllegalArgumentException("End time value cannot be negative or 0");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            if (end <= start) {
                throw new IllegalArgumentException("End time value should be greater than start time");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            if (title == null) { throw new NullPointerException("Title value cannot be null");
            }
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException => " + e.getMessage());

        }
        try {
            if (interval <= 0) {
                throw new IllegalArgumentException("Interval value cannot be negative or 0");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
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
     * @param title is the argument which sets a tasks title
     */
    public void setTitle(String title) {
        try {
            if (title == null) {
                throw new NullPointerException("Title cannot be null");
            }
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException => " + e.getMessage());
        }
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
     * @param active is the argument which sets task to active status
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * This method implements returning repetition start time of the task
     * if the task is a repetitive one and execution time is the task is non-repetitive
     */
    public int getTime() {
        if (repeated) {
            return start;
        }
        return time;
    }

    /**
     * This method implements setting of start time of non-repetitive
     * task and makes repetitive task non-repetitive
     * @param time is the argument which sets a start time of non-repetitive task
     */
    public void setTime(int time) {
        try {
            if (time <= 0) { throw new IllegalArgumentException("Time cannot be negative or 0");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        if (repeated) {
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
        if (!repeated) {
            return time;
        }
        return end;
    }

    /**
     * This method returns repeat interval for repetitive task and
     * returns 0 for non-repetitive task
     */
    public int getRepeatInterval() {
        if (!repeated) {
            return 0;
        }
        return interval;
    }

    /**
     * This method is setting start and end time of the repetitive tasks and
     * repeat interval for them, and makes non-repetitive task repetitive
     * @param start is the argument which sets start time of repetitive task
     * @param end is the argument which sets end time of repetitive task
     * @param interval is the argument which sets interval for task repetition
     */
    public void setTime(int start, int end, int interval) {
        try {
            if (start <= 0) {
                throw new IllegalArgumentException("Start time cannot be negative or 0");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            if (end <= 0) {
                throw new IllegalArgumentException("End time cannot be negative or 0");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            if (end <= start) {
                throw new IllegalArgumentException("End time should be greater than start time");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
        try {
            if (title == null) { throw new NullPointerException("Title cannot be null");
            }
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException => " + e.getMessage());

        }
        try {
            if (interval <= 0) {
                throw new IllegalArgumentException("Interval value cannot be negative or 0");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
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
     * @param current is the argument which set the current time
     */
    public int nextTimeAfter (int current) {
        if (active && repeated == false && time > 0) {
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

    /**
     * This method returns task's parameters as a string values
     */
    @Override
    public String toString() {
        return "TaskImpl{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", start=" + start +
                ", end=" + end +
                ", active=" + active +
                ", repeated=" + repeated +
                ", interval=" + interval +
                ", current=" + current +
                '}';
    }
}