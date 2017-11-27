package be.cegeka.bibliothouris.domain.users;

import javax.inject.Named;

@Named
public class UserMapper {
    public User makeUserFromUserDto(UserDto userDto) {
        return new User(userDto.inss,userDto.lastname,userDto.firstname,userDto.street,userDto.number,userDto.postalcode,userDto.city);
    }
}
