package com.learning_project_spring_boot.LearnProject.Service;

import com.learning_project_spring_boot.LearnProject.Model.StudentModel;
import com.learning_project_spring_boot.LearnProject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentModel createStudent(StudentModel student) {
        return studentRepository.save(student);
    }

    public List<StudentModel> retrieveAll() {
        return studentRepository.findAll();
    }

    public Optional<StudentModel> findById(Integer studentId) {
        return studentRepository.findById(studentId.longValue());
    }

    public StudentModel modifyStudent(Integer studentId, StudentModel updatedData) {
        StudentModel student = studentRepository.findById(studentId.longValue())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setFullName(updatedData.getFullName());
        student.setBranch(updatedData.getBranch());
        student.setMarks(updatedData.getMarks());
        student.setInstitution(updatedData.getInstitution());

        return studentRepository.save(student);
    }

    public StudentModel updateFullName(Integer studentId, String newName) {
        StudentModel student = studentRepository.findById(studentId.longValue())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setFullName(newName);
        return studentRepository.save(student);
    }

    public boolean removeStudent(Integer studentId) {
        if (studentRepository.existsById(studentId.longValue())) {
            studentRepository.deleteById(studentId.longValue());
            return true;
        }
        return false;
    }

    public List<StudentModel> searchByBranch(String branch) {
        return studentRepository.findByBranch(branch);
    }

    public List<StudentModel> searchByInstitution(String institution) {
        return studentRepository.findByInstitution(institution);
    }

    public List<StudentModel> findByMarksGreaterThan(Integer marks) {
        return studentRepository.findByMarksGreaterThan(marks.doubleValue());
    }

    public List<StudentModel> findByFullNameContaining(String name) {
        return studentRepository.findByFullNameContaining(name);
    }

    public Optional<StudentModel> findByIdAndInstitution(Integer id, String institution) {
        return studentRepository.findByIdAndInstitution(id.longValue(), institution);
    }
}
