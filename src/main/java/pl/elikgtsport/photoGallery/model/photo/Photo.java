package pl.elikgtsport.photoGallery.model.photo;

import lombok.Data;
import pl.elikgtsport.photoGallery.model.gallery.Gallery;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "photos")
public class Photo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_photo")
    private Long id;
    @Column
    private String nameOfPhoto;

    @ManyToOne
    @JoinColumn(name = "gallery_id_fk") //name column with foreign key from Gallery
    private Gallery gallery;

    @Override
    public String toString() {
        return "Photo [id=" + id
                + ", nameOfPhoto="
                + nameOfPhoto
                + gallery.getNameOfGallery()
                + "]";
    }
}
