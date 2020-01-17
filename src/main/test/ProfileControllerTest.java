package me.kyllian.netflixstatistix.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@runWith(MockitoJUnitRunner.class)
class ProfileControllerTest {

    @Mock
    private ImageView logo;

    @InjectMocks
    private ProfileController profileController;

    @Test
    public void testTestLogoExistence(){
        profileController.testTestLogoExistence;
    }
}