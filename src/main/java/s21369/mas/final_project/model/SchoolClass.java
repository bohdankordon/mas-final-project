package s21369.mas.final_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idClassroom", nullable = false, referencedColumnName = "id")
    @NotNull
    private Classroom classroom;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idSubject", nullable = false, referencedColumnName = "id")
    @NotNull
    private Subject subject;

    @Column(nullable = false)
    @Min(value = 1, message = "School year should not be less than 1!")
    @Max(value = 12, message = "School year should not be greater than 12!")
    private byte schoolYear;

    @Column(nullable = false)
    @Min(value = 51, message = "Min passing grade should not be less than 51!")
    private short minPassGrade;

    @Column(nullable = false)
    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;

}
