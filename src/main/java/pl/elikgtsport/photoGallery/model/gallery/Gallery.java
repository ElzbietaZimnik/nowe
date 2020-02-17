package pl.elikgtsport.photoGallery.model.gallery;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.elikgtsport.photoGallery.model.photo.Photo;
import pl.elikgtsport.photoGallery.model.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "galleries")
@NoArgsConstructor
public class Gallery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gallery")
    private Long id;
    @Column
    private String nameOfGallery;

//(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST}) //ładowanie zachłanne, domyślnie leniwie

    @ManyToMany
    @JoinTable(name = "gallery_users",
            joinColumns = {@JoinColumn(name = "gallery_id", referencedColumnName = "id_gallery")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id_user")})
    private List<User> users;


    //entity Gallery is owner of relation
    @OneToMany(mappedBy="gallery")
    private List<Photo> photos;


    @Override
    public String toString() {
        return "Gallery [id=" + id
                + ", nameOfGallery="
                + nameOfGallery
                + "]";
    }
}
