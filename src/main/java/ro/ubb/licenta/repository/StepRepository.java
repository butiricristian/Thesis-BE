package ro.ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubb.licenta.model.Step;

@Repository
public interface StepRepository extends JpaRepository<Step, Long>{
}
