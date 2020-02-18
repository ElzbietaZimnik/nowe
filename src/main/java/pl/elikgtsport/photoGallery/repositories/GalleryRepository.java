package pl.elikgtsport.photoGallery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.elikgtsport.photoGallery.model.gallery.Gallery;

import java.util.List;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Long> {

    List<Gallery> findAll();

    Gallery findByNameOfGallery(String nameOfGallery);

    void deleteById(Gallery id);

//    void updateGallery(Long id, String nameOfGallery);
}
