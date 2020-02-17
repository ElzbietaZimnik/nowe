package pl.elikgtsport.photoGallery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.elikgtsport.photoGallery.model.user.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
    void deleteUserByLogin(String login);
}
