package user;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *У вас есть два класса - UserService и UserRepository. UserService использует UserRepository для получения
 * информации о пользователе. Ваша задача - написать интеграционный тест, который проверяет, что UserService и
 * UserRepository работают вместе должным образом.
 */

class UserServiceTest {

    @Test
    void testGetUserName() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        assertThat(userService.getUserName(1)).isEqualTo("User 1");
    }
}