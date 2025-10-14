package com.learning_project_spring_boot.LearnProject.Controller;

import com.learning_project_spring_boot.LearnProject.Model.StudentModel;
import com.learning_project_spring_boot.LearnProject.Service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/addstudent")
    public ResponseEntity<Map<String, String>> createStudent(@Valid @RequestBody StudentModel student) {
        Map<String, String> response = new HashMap<>();

        try {
            service.createStudent(student);
            response.put("status", "success");
            response.put("message", "Student record created");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Failed to create student");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
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
    public ResponseEntity<Map<String, String>> updateStudent(
            @PathVariable Integer id,
            @Valid @RequestBody StudentModel student) {

        Map<String, String> response = new HashMap<>();

        try {
            service.modifyStudent(id, student);
            response.put("status", "success");
            response.put("message", "Student details updated");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("status", "error");
            response.put("message", "Student ID not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PatchMapping("/rename/{id}")
    public ResponseEntity<Map<String, String>> renameStudent(
            @PathVariable Integer id,
            @RequestBody Map<String, String> payload) {

        Map<String, String> response = new HashMap<>();
        String newName = payload.get("fullName");

        if (newName == null || newName.trim().isEmpty()) {
            response.put("status", "error");
            response.put("message", "Full name cannot be blank");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            service.updateFullName(id, newName);
            response.put("status", "success");
            response.put("message", "Name updated successfully");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("status", "error");
            response.put("message", "Student not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
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
    public ResponseEntity<List<StudentModel>> searchByBranch(
            @RequestParam
            @NotBlank(message = "Branch parameter cannot be blank")
            String branch) {

        List<StudentModel> students = service.searchByBranch(branch);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<StudentModel>> searchByName(@RequestParam String name) {
        List<StudentModel> students = service.findByFullNameContaining(name);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/search/institution/{id}")
    public ResponseEntity<?> findByIdAndInstitution(
            @PathVariable Integer id,
            @RequestParam String institution) {

        Optional<StudentModel> student = service.findByIdAndInstitution(id, institution);

        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        }

        Map<String, String> error = new HashMap<>();
        error.put("error", "Student not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
