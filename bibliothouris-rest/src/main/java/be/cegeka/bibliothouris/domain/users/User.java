package be.cegeka.bibliothouris.domain.users;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "INSS")
    private String inss;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSENUMBER")
    private String houseNumber;
    @Column(name = "POSTALCODE")
    private String postalCode;
    @Column(name = "CITY")
    private String city;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")}
    )
    private List<Role> roles;


    private User(){
    }

    public User(String inss,
                String lastName,
                String firstName,
                String street,
                String houseNumber,
                String postalCode,
                String city) {
        this.inss = inss;
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getInss() {
        return inss;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return firstName != null ? firstName.equals(user.firstName) : user.firstName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }
}
