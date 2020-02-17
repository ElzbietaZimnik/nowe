package pl.elikgtsport.photoGallery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pl.elikgtsport.photoGallery.repositories.UserRepository;
import pl.elikgtsport.photoGallery.repositories.UserRoleRepository;
import pl.elikgtsport.photoGallery.model.user.User;
import pl.elikgtsport.photoGallery.model.user.UserRole;

import java.util.List;


@Service
public class UserService {

    private static final String DEFAULT_ROLE = "ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
//    @Autowired
//    public UserService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Autowired
//    public void setRoleRepository(UserRoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }

    public void addWithDefaultRole(User user) {
        UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(defaultRole);
        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User u) {
        userRepository.save(u);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }


    public void deleteUserByLogin(String login) {
        userRepository.deleteUserByLogin(login);
    }

}
