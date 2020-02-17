package pl.elikgtsport.photoGallery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.elikgtsport.photoGallery.model.photo.Photo;
import pl.elikgtsport.photoGallery.repositories.PhotoRepository;

import java.util.List;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }


    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    public void addPhoto(Photo photo) {
        photoRepository.save(photo);
    }

    public Photo findByNameOfPhoto(String nameOfPhoto) {
        return photoRepository.findByNameOfPhoto(nameOfPhoto);
    }
}
