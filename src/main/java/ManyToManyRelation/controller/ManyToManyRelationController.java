package ManyToManyRelation.controller;

import ManyToManyRelation.entity.Course;
import ManyToManyRelation.entity.Student;
import ManyToManyRelation.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedHashMap;

@Controller
public class ManyToManyRelationController {
    private StudentRepository studentRepository;

    public ManyToManyRelationController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/")
    public ResponseEntity<Student> postStudentHandler(@RequestBody LinkedHashMap requestBody){
        Student student = new Student(requestBody.get("firstname").toString(),requestBody.get("lastname").toString());
        student.addCourse(new Course("course title"));
        studentRepository.save(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
