package pl.elikgtsport.photoGallery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.elikgtsport.photoGallery.model.photo.Photo;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    Photo findByNameOfPhoto(String nameOfPhoto);
    List<Photo> findAll();
}
