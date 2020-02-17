package pl.elikgtsport.photoGallery.controller.controller.gallery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KrzychuController {

    @GetMapping("/krzychu")
    String elaJestSuper() {
        return "ela jest super!";
    }


}
