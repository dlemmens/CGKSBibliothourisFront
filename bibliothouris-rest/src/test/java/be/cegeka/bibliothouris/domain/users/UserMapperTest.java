package be.cegeka.bibliothouris.domain.users;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {
    @InjectMocks
    private UserMapper userMapper;

    @Test
    public void makeUserFromUserDto() throws Exception {
        UserDto test = new UserDto("inss", "lastname", "firstname", "street", "number", "postalcode", "city");
        User usertest = new User("inss", "lastname", "firstname", "street", "number", "postalcode", "city");
        assertThat(userMapper.makeUserFromUserDto(test)).isEqualTo(usertest);
    }

}