 package backend.project.cookingapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backend.project.cookingapp.domain.SignupForm;
import backend.project.cookingapp.domain.User;
import backend.project.cookingapp.domain.UserRepository;
import jakarta.validation.Valid;


@Controller
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "signup";
    }


    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
        System.out.println("Save method called");
        if (!bindingResult.hasErrors()) {
            if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) {		
                String hashedPassword = new BCryptPasswordEncoder().encode(signupForm.getPassword());
    
                User newUser = new User();
                newUser.setUsername(signupForm.getUsername());
                newUser.setPasswordHash(hashedPassword);
                newUser.setRole("USER");
    
                userRepository.save(newUser);
    
                return "redirect:/login";
            } else {

                bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords do not match");
            }
        }
    
        return "signup";
    }
    

}


