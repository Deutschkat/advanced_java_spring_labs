package platform.codingnomads.co.springtest.usingmockmvc;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Bobbert");
        return "greeting";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String greet() {
        return "Hello Back";
    }

    @GetMapping("/not-found")
    public String notFound() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("name", "Ozzy");
        model.addAttribute("age", 70);
        return "profile";
    }

    @GetMapping("/redirect")
    public String redirectToHello() {
        return "redirect:/hello";
    }


}
