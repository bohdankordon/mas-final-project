package s21369.mas.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s21369.mas.final_project.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {



}
