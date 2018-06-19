package ro.ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubb.licenta.model.ArrayElement;

@Repository
public interface ArrayElementRepository extends JpaRepository<ArrayElement, Long> {
}
