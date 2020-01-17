import javafx.scene.image.ImageView;
import me.kyllian.netflixstatistix.controllers.ProfileController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProfileControllerTest {

    @Mock
    private ImageView logo;

    @InjectMocks
    private ProfileController profileController;

    @Test
    public void testTestLogoExistence(){
        profileController.testLogoExistence();
    }
}