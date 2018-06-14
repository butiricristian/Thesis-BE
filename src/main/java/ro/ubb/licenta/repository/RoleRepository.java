package ro.ubb.licenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.licenta.model.Role;
import ro.ubb.licenta.model.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
