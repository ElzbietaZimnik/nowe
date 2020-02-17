package pl.elikgtsport.photoGallery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.elikgtsport.photoGallery.model.user.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByRole(String role);
}
