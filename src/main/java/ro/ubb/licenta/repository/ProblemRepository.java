package ro.ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubb.licenta.model.Problem;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long>{
}
