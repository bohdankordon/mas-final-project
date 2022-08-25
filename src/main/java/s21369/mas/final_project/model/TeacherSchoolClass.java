package s21369.mas.final_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

// could be changed
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"idTeacher", "idSchoolClass"}))
public class TeacherSchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idTeacher", nullable = false, referencedColumnName = "id")
    @NotNull
    private Teacher teacher;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idSchoolClass", nullable = false, referencedColumnName = "id")
    @NotNull
    private SchoolClass schoolClass;

}
