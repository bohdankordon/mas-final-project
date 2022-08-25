package s21369.mas.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s21369.mas.final_project.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findDistinctFirstByFirstName(String firstName);

}
