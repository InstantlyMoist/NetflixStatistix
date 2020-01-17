import javafx.scene.control.Label;
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

    @Mock
    private Label profileMainText;

    @Mock
    private Label profile1Text;

    @Mock
    private Label profile2Text;

    @Mock
    private Label profile3Text;

    @Mock
    private Label profile4Text;

    @Mock
    private Label profile5Text;

    @Mock
    private ImageView profilePicture1;

    @Mock
    private ImageView profilePicture2;

    @Mock
    private ImageView profilePicture3;

    @Mock
    private ImageView profilePicture4;

    @Mock
    private ImageView profilePicture5;

    @InjectMocks
    private ProfileController profileController;

    @Test
    public void testTestExistenceOfAllElements(){
        profileController.TestExistenceOfAllElements();
    }
}