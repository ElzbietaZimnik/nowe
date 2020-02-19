package pl.elikgtsport.photoGallery.controller.controller.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.elikgtsport.photoGallery.services.UserService;
import pl.elikgtsport.photoGallery.model.user.DtoUserRegistration;
import pl.elikgtsport.photoGallery.model.user.User;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor //don't have to generate constructor and annotation @Autowired
public class UserController {

  private final UserService userService;

    @GetMapping("/")
    public String homepage() {
        log.info("Viewing homepage");
        return "index";
    }

    @GetMapping("/secured")
    public String login() {
        log.info("Logging");
        return "loggedUser";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("dtoUserRegistration", new DtoUserRegistration());
        return "registerForm";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute @Valid DtoUserRegistration dto,
                          BindingResult bindResult) {
        log.info("Adding new user {}", dto);
        User existing = userService.findByLogin(dto.getLogin());
        if (existing != null) {
            bindResult.rejectValue("login", null, "Account is already exist");
        }
        if (bindResult.hasErrors()) {
            return "registerForm";
        } else {
            User user = new User();
            user.setLogin(dto.getLogin());
            user.setPassword(dto.getPassword());
            userService.addWithDefaultRole(user);
            return "registerSuccess";
        }
    }

//    @PostMapping("/users/delete/{login}")
//    public String remove(@PathVariable String login) {
//        userService.deleteUserByLogin(login);
//        return "redirect:/users";
//    }

    @ModelAttribute("dtoUserRegistration")
    public DtoUserRegistration dtoUserRegistration() {
        return new DtoUserRegistration();
    }

    @GetMapping("/showUsers")
    public String showAllUsers(Model model) {
        log.info("Show users list");
        model.addAttribute("userList", userService.findAll());
        return "showAllUsers";
    }










}
