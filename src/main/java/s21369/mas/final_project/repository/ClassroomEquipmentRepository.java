package s21369.mas.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s21369.mas.final_project.model.Classroom;
import s21369.mas.final_project.model.ClassroomEquipment;

import java.util.List;

public interface ClassroomEquipmentRepository extends JpaRepository<ClassroomEquipment, Long> {

    List<ClassroomEquipment> findAllByClassroom(Classroom classroom);

}
