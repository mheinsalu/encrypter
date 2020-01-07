package ee.mrtnh.encrypter_demo.repository;

import ee.mrtnh.encrypter_demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    User user = new User("testUser", "testPassword");

    @BeforeEach
    void setUp() {
        userRepository.save(user);
    }

    @Test
    void findUserByUserName() {
        User foundUser = userRepository.findUserByUserName(user.getUserName());
        assertThat(user.equals(foundUser));
    }
}