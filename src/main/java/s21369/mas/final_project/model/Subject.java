package s21369.mas.final_project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Subject should not be null or empty!")
    @Size(min = 2, max = 256)
    private String subject;

    @Column(nullable = false)
    @NotBlank(message = "Description should not be null or empty!")
    @Size(min = 8, max = 4096)
    private String description;

}
