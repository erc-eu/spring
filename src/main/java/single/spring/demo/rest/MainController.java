package single.spring.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import single.spring.demo.model.User;
import single.spring.demo.service.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping("/demo") // This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired 
  UserRepository userRepository;


  @PostMapping // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestBody User usuario) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    userRepository.save(usuario);
    return "Saved";
  }

  @GetMapping
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
}