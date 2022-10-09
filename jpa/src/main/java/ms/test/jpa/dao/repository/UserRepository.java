package ms.test.jpa.dao.repository;

import ms.test.jpa.dao.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

}
