package edu.isu.cs.cs2263;
import java.util.ArrayList;

/**
 * This is a student object class
 */

public class Student {
    String firstName;
    String lastName;
    ArrayList<Course> Courses = new ArrayList<>();

    /**
     * @param firstName set the first name of the student
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName set the last name of the student object
     */

    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * @param course adds a course object to a student's courses arraylist
     */

    public void addCourse(Course course){Courses.add(course);}

    /**
     * @return retrieves first name of student object
     */

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Course> getCourses() {
        return Courses;
    }

    public String toString() {
        return firstName +
                " " + lastName;
    }
}

