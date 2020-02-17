package pl.elikgtsport.photoGallery.model.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public String toString() {
        return "UserRole [id=" + id
                + ", role=" + role
                + ", description=" + description + "]";
    }


}
