package s21369.mas.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import s21369.mas.final_project.model.SchoolClass;
import s21369.mas.final_project.model.TeacherSchoolClass;

import java.util.List;

public interface TeacherSchoolClassRepository extends JpaRepository<TeacherSchoolClass, Long> {

    List<TeacherSchoolClass> findAllBySchoolClass(SchoolClass schoolClass);

    @Query(value = "SELECT * FROM TeacherSchoolClass " +
            "WHERE idSchoolClass = :schoolClassId LIMIT 1",
            nativeQuery = true)
    TeacherSchoolClass findFirstBySchoolClassId(@Param("schoolClassId") Long id);

}
