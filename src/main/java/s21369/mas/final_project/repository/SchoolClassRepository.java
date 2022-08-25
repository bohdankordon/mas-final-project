package s21369.mas.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import s21369.mas.final_project.model.SchoolClass;
import s21369.mas.final_project.model.Student;

import java.util.List;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {

    List<SchoolClass> findAllBySchoolYear(byte schoolYear);

    @Query("SELECT sc FROM SchoolClass sc " +
            "WHERE sc.schoolYear = :schoolYear AND " +
            "LOWER(sc.subject.subject) LIKE LOWER(CONCAT('%', :subjectName, '%'))")
    List<SchoolClass> findAllBySchoolYearAndSubjectNameLike(@Param("schoolYear") byte schoolYear,
                                                           @Param("subjectName") String subjectName);

    SchoolClass findSchoolClassById(Long id);

}
