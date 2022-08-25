package s21369.mas.final_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "First name should not be null or empty!")
    @Size(min = 2, max = 128)
    private String firstName;

    @Column(nullable = false)
    @NotBlank(message = "Last name should not be null or empty!")
    @Size(min = 2, max = 128)
    private String lastName;

    @Column(nullable = false)
    @NotNull
    private LocalDate birthDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SexType sex;

    @Column(nullable = false)
    @NotBlank(message = "Address should not be null or empty!")
    @Size(min = 8, max = 256)
    private String address;

}
