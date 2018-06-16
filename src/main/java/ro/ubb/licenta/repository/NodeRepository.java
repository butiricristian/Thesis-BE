package ro.ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ubb.licenta.model.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {
}
