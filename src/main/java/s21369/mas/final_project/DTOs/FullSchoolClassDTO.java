package s21369.mas.final_project.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s21369.mas.final_project.model.ClassroomEquipment;
import s21369.mas.final_project.model.Equipment;
import s21369.mas.final_project.model.SchoolClass;
import s21369.mas.final_project.model.Teacher;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FullSchoolClassDTO {

    private SchoolClass schoolClass;
    private List<Teacher> teachers;
    private List<ClassroomEquipment> classroomEquipments;

}
