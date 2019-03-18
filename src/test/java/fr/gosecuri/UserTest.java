package fr.gosecuri;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserTest {
    @Test
    public void createUser() {
        User user = new User("01/01/2000","Full Name");
        assertEquals("User created", "Full Name", user.full_name);
    }

}
