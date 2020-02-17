package pl.elikgtsport.photoGallery.model.gallery;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DtoGallery {

    @NotEmpty(message = "This field can't be empty")
    public String nameOfGallery;
    private Long id;

//    private String nameOfGallery;

}
