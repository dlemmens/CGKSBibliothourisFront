package be.cegeka.bibliothouris.domain.users;

public class UserDto {
    public String inss;
    public String lastname;
    public String firstname;
    public String street;
    public String number;
    public String postalcode;
    public String city;

    public UserDto(String inss, String lastname, String firstname, String street, String number, String postalcode, String city) {
        this.inss = inss;
        this.lastname = lastname;
        this.firstname = firstname;
        this.street = street;
        this.number = number;
        this.postalcode = postalcode;
        this.city = city;
    }
}
