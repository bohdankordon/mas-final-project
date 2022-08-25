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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"idClassroom", "idEquipment"}))
public class ClassroomEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idClassroom", nullable = false, referencedColumnName = "id")
    @NotNull
    private Classroom classroom;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idEquipment", nullable = false, referencedColumnName = "id")
    @NotNull
    private Equipment equipment;

    @Column(nullable = false)
    @Min(value = 0, message = "Quantity should not be less than 0!")
    private byte quantity;

}
