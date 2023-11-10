package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    private User user;

    @BeforeEach
    void setup(){
        user = new User("Alex", "123", true);
    }
    @Test
    void authentificationTestPass(){
        assertTrue(user.authenticate("Alex", "123"));
    }
    @Test
    void authentificationTestFailed(){
        assertFalse(user.authenticate("qwer", "asdf"));
    }

}