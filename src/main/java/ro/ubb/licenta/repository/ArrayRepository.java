package ro.ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubb.licenta.model.ArrayComponent;

@Repository
public interface ArrayRepository extends JpaRepository<ArrayComponent, Long> {
}
