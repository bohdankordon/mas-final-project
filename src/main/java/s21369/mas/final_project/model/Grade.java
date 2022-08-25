package s21369.mas.final_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idStudentSchoolClass", nullable = false, referencedColumnName = "id")
    @NotNull
    private StudentSchoolClass studentSchoolClass;

    @Column(nullable = false)
    @Min(value = 0, message = "Final grade should not be less than 0!")
    private short grade;

}
