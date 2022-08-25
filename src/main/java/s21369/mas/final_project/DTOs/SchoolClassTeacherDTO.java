package s21369.mas.final_project.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s21369.mas.final_project.model.SchoolClass;
import s21369.mas.final_project.model.Teacher;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SchoolClassTeacherDTO {

    private SchoolClass schoolClass;
    private Teacher teacher;

}
