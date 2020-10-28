package ManyToManyRelation.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="courses_students",joinColumns = @JoinColumn(name="course_id"),
                inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> studentList;

    public void addStudent(Student student){
        if(studentList == null){
            studentList = new ArrayList<>();
        }
        studentList.add(student);
    }

    public Course(String title) {
        this.title = title;
    }

    public Course(String title, List<Student> studentList) {
        this.title = title;
        this.studentList = studentList;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
