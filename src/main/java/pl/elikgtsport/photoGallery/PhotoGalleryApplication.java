package pl.elikgtsport.photoGallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.elikgtsport.photoGallery.model.gallery.Gallery;
import pl.elikgtsport.photoGallery.model.user.User;
import pl.elikgtsport.photoGallery.repositories.GalleryRepository;
import pl.elikgtsport.photoGallery.repositories.UserRepository;

@SpringBootApplication
public class PhotoGalleryApplication {
//public class PhotoGalleryApplication implements CommandLineRunner {

//	@Autowired
//	GalleryRepository galleryRepository;
//	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(PhotoGalleryApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		User u = new User();
//		u.setLogin("u");
//		u.setPassword("u");
//		userRepository.save(new User());
//	}
}
