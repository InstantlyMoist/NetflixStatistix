import me.kyllian.netflixstatistix.post.PasswordEncryptor;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class MyTest {

    @Test
    public void passwordGetsEncrypted() {
        String password = "Password123";
        String encrypted = PasswordEncryptor.encrypt(password);
        assertNotEquals(password, encrypted);
    }
}
