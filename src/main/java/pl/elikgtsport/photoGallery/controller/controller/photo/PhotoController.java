package pl.elikgtsport.photoGallery.controller.controller.photo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.elikgtsport.photoGallery.model.photo.DtoPhoto;
import pl.elikgtsport.photoGallery.model.photo.Photo;
import pl.elikgtsport.photoGallery.services.PhotoService;


import javax.validation.Valid;


@Controller
@Slf4j
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @GetMapping("/showPhotos")
    public String showAllPhotos(Model model) {
        log.info("Showing photo list");
        model.addAttribute("photoList", photoService.findAll());
        model.addAttribute("dtoPhoto", new DtoPhoto());
        return "showAllPhotos";
    }

    @GetMapping("/photos")
    public String addPhoto(Model model) {
        model.addAttribute("dtoPhoto", new DtoPhoto());
        return "addPhoto";
    }

    @ModelAttribute("dtoPhoto")
    public DtoPhoto dtoPhoto() {
        return new DtoPhoto();
    }

    @PostMapping("/photos")
    public String addPhoto(@ModelAttribute @Valid DtoPhoto dto,
                             BindingResult bindResult) {
        log.info("Adding new photo {}", dto);

        Photo existing = photoService.findByNameOfPhoto(dto.getNameOfPhoto());
        if (existing != null) {
            bindResult.rejectValue("nameOfPhoto", null, "Photo is already exist");
        }
        if (bindResult.hasErrors()) {
            return "NOT FOUND";
        } else {
            Photo photo = new Photo();
            photo.setNameOfPhoto(dto.getNameOfPhoto());
            photoService.addPhoto(photo);
            return "addPhoto";
        }
    }




//    @PostMapping("/photos")
//    public String addTask(@ModelAttribute("newPhoto") Photo request,
//                              @RequestParam("attachment")
//                                      MultipartFile attachment) throws IOException {
//        Photo photo = photoService.addPhoto(request.getId(), request.getNameOfPhoto());
//        storageService.saveFile(photo.getId(), attachment);
//        return "redirect:/";
//    }



}
