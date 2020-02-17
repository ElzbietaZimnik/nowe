package pl.elikgtsport.photoGallery.model.photo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class DtoPhoto {

    private Long id;
    @NotEmpty(message = "This field can't be empty")
    private String nameOfPhoto;
}
