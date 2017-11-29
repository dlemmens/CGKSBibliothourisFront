package be.cegeka.bibliothouris.domain.users;

import javax.inject.Named;

@Named
public class UserMapper {
    public User makeUserFromUserDto(UserDto userDto) {
        return new User(userDto.inss,userDto.lastName,userDto.firstName,userDto.street,userDto.houseNumber,userDto.postalCode,userDto.city);
    }
}
