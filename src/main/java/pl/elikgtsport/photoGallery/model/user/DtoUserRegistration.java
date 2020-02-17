package pl.elikgtsport.photoGallery.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class DtoUserRegistration {

    private Long id;

    @NotEmpty(message = "This field can't be empty")
    @Size(min = 3, max = 15, message = "This field has to include min 3 characters and max 15")
    private String login;

    @NotEmpty(message = "This field can't be empty")
    private String password;

}
