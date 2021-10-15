package edu.isu.cs.cs2263;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.application.Application;
import java.util.ArrayList;

/**
 * @Author Coby Garner
 * @version 2.0.0
 */

public class App extends Application{
    @Override

    //Student list setup
    public void start(Stage myStage) throws Exception {
        Course cs1181 = new Course(); cs1181.setNumber(1181); cs1181.setSubject("CS"); cs1181.setTitle("Intro to programming");
        Course engl3307 = new Course(); engl3307.setSubject("ENGL"); engl3307.setNumber(3307); engl3307.setTitle("Technical Communication");
        Course math1187 = new Course(); math1187.setTitle("Applied discrete Structures"); math1187.setNumber(1187); math1187.setSubject("MATH");
        Student student1 = new Student(); student1.setFirstName("Coby"); student1.setLastName("Garner"); student1.addCourse(cs1181); student1.addCourse(math1187);
        Student student2 = new Student(); student2.setFirstName("John"); student2.setLastName("Smith"); student2.addCourse(engl3307);
        Student student3 = new Student(); student3.setFirstName("Jane"); student3.setLastName("Doe"); student3.addCourse(math1187);
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1); students.add(student2); students.add(student3);

        //stage and scene setup
        myStage.setTitle("Students and courses"); myStage.setWidth(1000); myStage.setHeight(1000);
        Label label = new Label("Is taking");
        Button button = new Button("Get data"); button.setLayoutY(950);
        ListView courseListView = new ListView<Course>();
        ListView studentListView = new ListView<Student>();
        studentListView.setMaxSize(400, 400);
        courseListView.setMaxSize(400, 400);
        HBox hbox = new HBox(studentListView, label, courseListView, button);
        Scene scene = new Scene(hbox, 200, 100);


        //Loads the list of students when clicking the load data button

        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                courseListView.getItems().clear();
                studentListView.getItems().clear();

                ArrayList<Student> dataList = IOManager.readData(IOManager.writeData(students));

                for (Student ss : dataList) {
                    studentListView.getItems().add(ss);
                }
            }
        });

        //gets courses for selected student and places courses in course listView
        studentListView.setOnMouseClicked(actionEvent -> {
            courseListView.getItems().clear();
            ArrayList<Student> dataList = IOManager.readData(IOManager.writeData(students));

            int selected = studentListView.getSelectionModel().getSelectedIndex();

            for(Course c: dataList.get(selected).getCourses()) {
                courseListView.getItems().add(c);
            }
        });

        myStage.setScene(scene);
        myStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}