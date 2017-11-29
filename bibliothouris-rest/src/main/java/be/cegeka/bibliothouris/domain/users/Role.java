package be.cegeka.bibliothouris.domain.users;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public Role() {
    }
}
