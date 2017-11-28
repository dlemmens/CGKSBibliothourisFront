package be.cegeka.bibliothouris.domain.users;

import org.springframework.test.util.ReflectionTestUtils;

public class UserTestBuilder {

    private String firstname;
    private int id;
    private String inss;
    private String lastname;
    private String city;
    private String street;
    private String number;
    private String postalCode;

    public static UserTestBuilder aUser(){
        return new UserTestBuilder()
                .withName("Seppe")
                .withInns("12335")
                .withLastName("Gielen")
                .withCity("Leuven");
        
    }

    public User build() {
        User user = new User(inss,lastname,firstname,street, number,postalCode,city);
        ReflectionTestUtils.setField(user, "id", id);
        return user;
        
    }

    public UserTestBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public UserTestBuilder withName(String name) {
        this.firstname = name;
        return this;
    }

    public UserTestBuilder withInns(String inss) {
        this.inss = inss;
        return this;
    }

    public UserTestBuilder withLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserTestBuilder withCity(String city) {
        this.city = city;
        return this;
    }
}



