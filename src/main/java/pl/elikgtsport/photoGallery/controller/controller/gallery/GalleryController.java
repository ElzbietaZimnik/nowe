package pl.elikgtsport.photoGallery.controller.controller.gallery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.elikgtsport.photoGallery.model.gallery.DtoGallery;
import pl.elikgtsport.photoGallery.model.gallery.Gallery;
import pl.elikgtsport.photoGallery.services.GalleryService;


import javax.validation.Valid;


@Controller
@Slf4j
@RequiredArgsConstructor
public class GalleryController {

    private final GalleryService galleryService;


    @GetMapping("/showGallerries")
    public String showAllGalleries(Model model) {
        log.info("Showing gallery list");
        model.addAttribute("galleriesList", galleryService.findAll());
        model.addAttribute("dtoGallery", new DtoGallery());
        return "showAllGalleries";
    }


    @GetMapping("/galleries")
    public String addGallery(Model model) {
        model.addAttribute("dtoGallery", new DtoGallery());
        return "addGallery";
    }

    @ModelAttribute("dtoGallery")
    public DtoGallery dtoGallery() {
        return new DtoGallery();
    }


    @PostMapping("/galleries")
    public String addGallery(@ModelAttribute @Valid DtoGallery dto,
                             BindingResult bindResult) {
        log.info("Adding new gallery {}", dto);

        Gallery existing = galleryService.findByNameOfGallery(dto.getNameOfGallery());
        if (existing != null) {
            bindResult.rejectValue("nameOfGallery", null, "Gallery is already exist");
        }
        if (bindResult.hasErrors()) {
            return "notFound";
        } else {
            Gallery gallery = new Gallery();
            gallery.setId(dto.getId());
            gallery.setNameOfGallery(dto.getNameOfGallery());
            galleryService.addGallery(gallery);
            return "addGallery";
        }
    }

    @GetMapping("/galleries/{id}")
    public ModelAndView getGalleryById(@PathVariable("id") Long id, ModelAndView modelAndView) {
        log.info("Getting Gallery by: id {}", id);
        modelAndView.setViewName("gallery");
        modelAndView.addObject("gallery", galleryService.findById(id));
        return modelAndView;
    }


    @GetMapping("/galleries/delete/{id}")
    public String removeGalllery(@PathVariable Long id, Model model) {
        log.info("Deleting gallery by: id {}", id);
        Gallery gallery = galleryService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incorrect gallery: " + id));
        galleryService.deleteById(gallery);
        model.addAttribute("gallery", galleryService.findAll());
        return "showAllGalleries";
    }


//    @GetMapping("/galleries/update/{id}")
//    public String updateGallery(@PathVariable Long id, @RequestBody DtoGallery dtoGallery, Model model) {
//        log.info("Updating gallery by: id {}", id);
//        galleryService.updateGallery(id, dtoGallery.nameOfGallery);
//        model.addAttribute("gallery", galleryService.findAll());
//        return "updateGallery";
//    }



}
