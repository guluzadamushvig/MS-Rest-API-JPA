package ms.test.jpa.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ms.test.jpa.dao.entity.User;
import ms.test.jpa.dao.entity.UserRequestResponse;
import ms.test.jpa.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/all/{id}")
    public UserRequestResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping("/update/{id}")
    public UserRequestResponse updateUser(@RequestBody UserRequestResponse userRequestResponse,
                                          @PathVariable Long id){
        return userService.updateUser(userRequestResponse,id);
    }
}
