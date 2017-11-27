package be.cegeka.bibliothouris.domain.users;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FIRSTNAME")
    private String firstname;
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


    private User(){
    }

    public User(String inss, String lastName,
                String firstName, String street, String houseNumber, String postalCode, String city) {
        this.inss = inss;
        this.lastName = lastName;
        this.firstname = firstName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
    }


    public String getFirstname() {
        return firstname;
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
        return firstname != null ? firstname.equals(user.firstname) : user.firstname == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        return result;
    }
}
