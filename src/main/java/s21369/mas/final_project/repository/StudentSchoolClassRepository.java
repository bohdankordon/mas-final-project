package s21369.mas.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s21369.mas.final_project.model.Student;
import s21369.mas.final_project.model.StudentSchoolClass;

import java.util.List;

public interface StudentSchoolClassRepository extends JpaRepository<StudentSchoolClass, Long> {

    List<StudentSchoolClass> findAllByStudent(Student student);
    StudentSchoolClass findByStudentAndSchoolClassId(Student student, Long id);

}
