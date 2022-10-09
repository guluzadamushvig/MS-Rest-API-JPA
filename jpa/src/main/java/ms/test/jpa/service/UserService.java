package ms.test.jpa.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import ms.test.jpa.dao.entity.User;
import ms.test.jpa.dao.entity.UserRequestResponse;
import ms.test.jpa.dao.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class UserService {
    private final UserRepository userRepository;

    public UserRequestResponse getUserById(Long id) {
        var user = userRepository.findById(id);
        User userMain = null;
        if (user.isPresent())
        {
             userMain = user.get();
        }
        else System.out.println("User not found");

        return UserRequestResponse.builder()
                .userName(userMain.getUserName())
                .build();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public UserRequestResponse updateUser(UserRequestResponse userRequestResponse,Long id) {
        var user = userRepository.findById(id);
        User foundedUser = null;
        UserRequestResponse returnUserRequestResponse = null;
        if (user.isPresent()){
            foundedUser=user.get();
            String name = userRequestResponse.getUserName();
            userRepository.updateUser(name,id);
        }
        else{
            System.out.println("User not found");
        }


        return returnUserRequestResponse.builder()
                .userName(foundedUser.getUserName())
                .build();
    }
}