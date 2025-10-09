package com.learning_project_spring_boot.LearnProject.Service;

import com.learning_project_spring_boot.LearnProject.Model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final List<StudentModel> database = new ArrayList<>();
    private int nextId = 1;

    public boolean createStudent(StudentModel student) {
        if (student.getId() == null) {
            student.setId(nextId++);
        }
        return database.add(student);
    }

    public List<StudentModel> retrieveAll() {
        return new ArrayList<>(database);
    }

    public Optional<StudentModel> findById(Integer studentId) {
        return database.stream()
                .filter(s -> s.getId().equals(studentId))
                .findFirst();
    }

    public boolean modifyStudent(Integer studentId, StudentModel updatedData) {
        Optional<StudentModel> existingStudent = findById(studentId);

        if (existingStudent.isPresent()) {
            StudentModel student = existingStudent.get();
            student.setFullName(updatedData.getFullName());
            student.setBranch(updatedData.getBranch());
            student.setMarks(updatedData.getMarks());
            student.setInstitution(updatedData.getInstitution());
            return true;
        }
        return false;
    }

    public boolean updateFullName(Integer studentId, String newName) {
        return findById(studentId)
                .map(student -> {
                    student.setFullName(newName);
                    return true;
                })
                .orElse(false);
    }

    public boolean removeStudent(Integer studentId) {
        return database.removeIf(s -> s.getId().equals(studentId));
    }

    public List<StudentModel> searchByBranch(String branch) {
        return database.stream()
                .filter(s -> s.getBranch().equalsIgnoreCase(branch))
                .collect(Collectors.toList());
    }
}
