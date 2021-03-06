package be.cegeka.bibliothouris.domain.users;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import static be.cegeka.bibliothouris.domain.users.UserTestBuilder.aUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Test
    public void addUser_ShouldCallUserRepository() throws Exception {
        UserDto test = new UserDto ("inss", "lastName","firstName","street","houseNumber","postalCode","city", "password");
        User testUser = userMapper.makeUserFromUserDto(test);
        userService.addUser(test);
        verify(userRepository).addUser(testUser);
    }

    @Test
    public void getAllUsers() throws Exception {
        User user1 =aUser().withName("Seppe").withInns("123").build();
        User user2 =aUser().withName("Sanne").withInns("1234").build();
        User user3 = aUser().withName("Xan").withInns("123456").build();

        when(userRepository.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        assertThat(userService.getAllUsers()).containsOnly(user1, user2);
    }

    @Test
    public void getUser_ShouldInvokeUserRepositoryAndReturnAUser() throws Exception {
        User user = aUser().build();

        when(userRepository.findUserByInss("123")).thenReturn(user);
        Assertions.assertThat(userService.getUser("123")).isEqualTo(user);
    }
}