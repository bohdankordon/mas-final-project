package s21369.mas.final_project.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Student extends Person {

    @Column(nullable = false)
    @Min(value = 1, message = "School year should not be less than 1!")
    @Max(value = 12, message = "School year should not be greater than 12!")
    private byte currentSchoolYear;

}
