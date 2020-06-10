package ro.bogdan.hibernatemappingdemo.onetoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    @ResponseBody
    public List<User> users() {
        return userDao.findAll();
    }

    @GetMapping("/create-dummy-user")
    @ResponseBody
    public User dummyUser() {
        User user = new User();
        user.setName("Bogdan");

        Address address = new Address();
        address.setLocation("Bucuresti");

        user.setAddress(address);

        userDao.save(user);

        return user;
    }
}
