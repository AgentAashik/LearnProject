package com.learning_project_spring_boot.LearnProject.Controller;

import com.learning_project_spring_boot.LearnProject.Model.StudentModel;
import com.learning_project_spring_boot.LearnProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createStudent(@RequestBody StudentModel student) {
        Map<String, String> response = new HashMap<>();

        if (service.createStudent(student)) {
            response.put("status", "success");
            response.put("message", "Student record created");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        response.put("status", "error");
        response.put("message", "Failed to create student");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<StudentModel>> getAllStudents() {
        List<StudentModel> students = service.retrieveAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
        Optional<StudentModel> student = service.findById(id);

        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        }

        Map<String, String> error = new HashMap<>();
        error.put("error", "Student not found with ID: " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, String>> updateStudent(@PathVariable Integer id, @RequestBody StudentModel student) {
        Map<String, String> response = new HashMap<>();

        if (service.modifyStudent(id, student)) {
            response.put("status", "success");
            response.put("message", "Student details updated");
            return ResponseEntity.ok(response);
        }

        response.put("status", "error");
        response.put("message", "Student ID not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PatchMapping("/rename/{id}")
    public ResponseEntity<Map<String, String>> renameStudent(@PathVariable Integer id, @RequestBody Map<String, String> payload) {
        Map<String, String> response = new HashMap<>();
        String newName = payload.get("fullName");

        if (service.updateFullName(id, newName)) {
            response.put("status", "success");
            response.put("message", "Name updated successfully");
            return ResponseEntity.ok(response);
        }

        response.put("status", "error");
        response.put("message", "Student not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable Integer id) {
        Map<String, String> response = new HashMap<>();

        if (service.removeStudent(id)) {
            response.put("status", "success");
            response.put("message", "Student removed successfully");
            return ResponseEntity.ok(response);
        }

        response.put("status", "error");
        response.put("message", "Student not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<StudentModel>> searchByBranch(@RequestParam String branch) {
        List<StudentModel> students = service.searchByBranch(branch);
        return ResponseEntity.ok(students);
    }
}

