package hello_user;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.ArrayList;

@Controller
public class GreetingController {

    User newUser = new User();

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=true) String name,
                           @RequestParam(name = "age", required = true) int age,
                           @RequestParam(name = "address", required = true) String address, Model model) {
        newUser.setName(name);
        newUser.setAge(age);
        newUser.setAddress(address);
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/user-info")
    public String userInfo(Model model) {
        model.addAttribute("age",newUser.getAge());
        model.addAttribute("address",newUser.getAddress());
        return "user-info";

    }

}
