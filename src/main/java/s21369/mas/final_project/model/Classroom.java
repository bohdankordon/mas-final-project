package s21369.mas.final_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Min(value = 1, message = "Floor should not be less than 1!")
    private byte floor;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Number should not be null or empty!")
    @Pattern(regexp = "[A-Z][0-9]{3}")
    private String number;

    @Column(nullable = false)
    @Min(value = 1, message = "Max capacity should not be less than 1!")
    private short maxCapacity;

}
