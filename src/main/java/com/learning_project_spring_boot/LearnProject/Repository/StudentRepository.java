package com.learning_project_spring_boot.LearnProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.learning_project_spring_boot.LearnProject.Model.StudentModel;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    List<StudentModel> findByBranch(String branch);

    List<StudentModel> findByInstitution(String institution);

    List<StudentModel> findByMarksGreaterThan(double marks);

    List<StudentModel> findByFullNameContaining(String name);

    Optional<StudentModel> findByIdAndInstitution(Long id, String institution);
}
