package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserDto;
import be.cegeka.bibliothouris.domain.users.UserService;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static be.cegeka.bibliothouris.domain.users.UserTestBuilder.aUser;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void getUsers() throws Exception {
       User seppe = aUser().withName("Seppe").build();
       User kiki = aUser().withName("Kiki").withInns("1223333").build();

        when(userService.getAllUsers()).thenReturn(Arrays.asList(seppe, kiki));
        Assertions.assertThat(userController.getUsers()).containsOnly(seppe, kiki);
    }

    @Test
    public void addUser() throws Exception {
        UserDto test = new UserDto ("inss", "lastname","firstname","street","number","postalcode","city");
        userController.addUser(test);
        verify(userService).addUser(test);
    }

}