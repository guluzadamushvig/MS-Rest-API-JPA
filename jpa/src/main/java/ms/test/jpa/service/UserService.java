package ms.test.jpa.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.test.jpa.dao.entity.User;
import ms.test.jpa.model.UserRequestResponse;
import ms.test.jpa.dao.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserRequestResponse getUserById(Long id) {
        log.info("ActionLog.getUserById.start id : {}", id);
        var user = userRepository.findById(id);
        User userMain = null;
        if (user.isPresent())
        {
            log.info("ActionLog.getUserById.userFound id : {}", id);
            userMain = user.get();
        }
        else {
            log.error("ActionLog.getUserById.userNotFound id : {}", id);
        };

        log.info("ActionLog.getUserById.successfully.finished id : {}", id);

        if (userMain != null) {
            return UserRequestResponse.builder()
                    .userName(userMain.getUserName())
                    .build();
        }
        else return null;
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


        if (foundedUser != null) {
            return returnUserRequestResponse.builder()
                    .userName(foundedUser.getUserName())
                    .build();
        }
        else return null;
    }
}