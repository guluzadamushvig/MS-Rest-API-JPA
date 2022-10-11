package ms.test.jpa.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ms.test.jpa.dao.entity.User;
import ms.test.jpa.dao.entity.UserRequestResponse;
import ms.test.jpa.service.UserService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user, @RequestHeader() String token){
        if (token.equals("testToken")){
        userService.addUser(user);
    }
        else {
            System.out.println("Authentication failed");
        }
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UserRequestResponse updateUser(@RequestBody UserRequestResponse userRequestResponse,
                                          @PathVariable Long id){
        return userService.updateUser(userRequestResponse,id);
    }
}
