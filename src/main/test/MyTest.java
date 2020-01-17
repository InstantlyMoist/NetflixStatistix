import me.kyllian.netflixstatistix.post.PasswordEncryptor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MyTest {

    @Test
    public void passwordGetsEncrypted() {
        String password = "Password123";
        String encrypted = PasswordEncryptor.encrypt(password);
        assertNotEquals(password, encrypted);
    }
}
