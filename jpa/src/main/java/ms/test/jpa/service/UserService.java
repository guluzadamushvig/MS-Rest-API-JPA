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
}
