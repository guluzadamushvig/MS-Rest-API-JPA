package ms.test.jpa.dao.repository;

import ms.test.jpa.dao.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE USER set USER_NAME = :userName WHERE id = :id", nativeQuery = true)
    void updateUser(@Param("userName") String name,@Param("id") Long id);
}
