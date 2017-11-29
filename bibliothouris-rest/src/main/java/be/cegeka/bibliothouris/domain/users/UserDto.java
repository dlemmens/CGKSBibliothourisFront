package be.cegeka.bibliothouris.domain.users;

public class UserDto {
    public String inss;
    public String lastName;
    public String firstName;
    public String street;
    public String houseNumber;
    public String postalCode;
    public String city;
    public String password;

    public UserDto() {
    }

    public UserDto(String inss, String lastName, String firstName, String street, String houseNumber, String postalCode, String city, String password) {
        this.inss = inss;
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.password = password;
    }
}
