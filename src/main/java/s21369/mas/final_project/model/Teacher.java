package s21369.mas.final_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Teacher extends Person {

    @ManyToOne(optional = false)
    @JoinColumn(name = "idTitle", nullable = false, referencedColumnName = "id")
    @NotNull
    private Title title;

    @Column(nullable = false)
    @NotBlank(message = "Last name should not be null or empty!")
    @Email
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "(?<!\\w)(\\(?(\\+|00)?48\\)?)?[ -]?\\d{3}[ -]?\\d{3}[ -]?\\d{3}(?!\\w)")
    private String phone;

}
