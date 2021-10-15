package edu.isu.cs.cs2263;


/**
 * This is a course object class
 */
public class Course {
    int number;
    String subject;
    String title;

    Course(){}

    /**
     * @param number course number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @param subject course subject prefix
     */

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @param title title of the course
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return course's assigned number
     */

    public int getNumber() {
        return number;
    }

    /**
     * @return course's assigned subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @return course's title
     */

    public String getTitle() {
        return title;
    }

    /**
     * @return formatted string describing course
     */
    public String toString() {
        return  subject +
                " " + number +
                " " + title;
    }
}
