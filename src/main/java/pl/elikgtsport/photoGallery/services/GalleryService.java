package pl.elikgtsport.photoGallery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.elikgtsport.photoGallery.model.gallery.Gallery;
import pl.elikgtsport.photoGallery.repositories.GalleryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryService {

    private GalleryRepository galleryRepository;

    @Autowired
    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    public Gallery findByNameOfGallery(String nameOfGallery) {
        return galleryRepository.findByNameOfGallery(nameOfGallery);
    }

    public List<Gallery> findAll() {
        return galleryRepository.findAll();
    }

    public void addGallery(Gallery gallery) {
        galleryRepository.save(gallery);
    }

    public Optional<Gallery> findById(Long id) {
        return galleryRepository.findById(id);
    }

//    public void deleteById(Long id) {
//        galleryRepository.deleteById(id);
//    }
//
//    public void deleteGallery(Gallery gallery) {
//        galleryRepository.delete(gallery);
//    }

//    public void updateGallery(Long id, String nameOfGallery) {
//        galleryRepository.updateGallery(id, nameOfGallery);
//    }
}