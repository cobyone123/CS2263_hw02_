package edu.isu.cs.cs2263;
import com.google.gson.Gson;
import java.util.ArrayList;

public class IOManager {

    /**
     *     @param file is an arraylist of strings
     *     @return deserStudents deserialized arraylist of students
     */

    // @
    public static ArrayList<Student> readData(ArrayList<String> file) {
        ArrayList<Student> deserStudents = new ArrayList<>();
        Gson gson = new Gson();
        for (String i : file) {
            Student st = gson.fromJson(String.valueOf(i), Student.class);
            deserStudents.add(st);
        }
        return deserStudents;
    }

    /**
     * @param students arraylist of Students
     * @return serialized list of students
     */

    public static ArrayList<String> writeData(ArrayList<Student> students) {
        ArrayList<String> serStudents = new ArrayList<>();
        Gson gson2 = new Gson();
        for (Student s : students) {
            String serStudent = gson2.toJson(s);
            serStudents.add(serStudent);
        }
        return serStudents;
    }
}