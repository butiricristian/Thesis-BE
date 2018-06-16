package ro.ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubb.licenta.model.Edge;
import ro.ubb.licenta.model.Node;

@Repository
public interface EdgeRepository extends JpaRepository<Edge, Long> {
}
