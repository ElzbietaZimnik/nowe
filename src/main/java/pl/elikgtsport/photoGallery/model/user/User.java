package pl.elikgtsport.photoGallery.model.user;

import lombok.Data;
import pl.elikgtsport.photoGallery.model.gallery.Gallery;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
   // @Column(unique = true, nullable = false)
    @Column(nullable = false)
    @NotNull
    private String login;
    @Column
    private String password;

    //private Gallery gallery;

    @ManyToMany(mappedBy = "users")
    private List<Gallery> galleries;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    @Override
    public String toString() {
        return "User [id=" + id
                + ", login=" + login
                + "]";
    }

}
