package be.cegeka.bibliothouris.domain.users;

import be.cegeka.bibliothouris.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static be.cegeka.bibliothouris.domain.users.UserTestBuilder.aUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@Transactional
public class UserRepositoryTest {

    @Inject
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private User seppe, kiki;

    @Before
    public void setup(){
        seppe = aUser().withName("Seppe").build();
        kiki = aUser().withName("Kiki").withInns("1223333").build();

        entityManager.persist(seppe);
        entityManager.persist(kiki);
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = userRepository.getAllUsers();

        assertThat(users).containsOnly(seppe, kiki);
    }

    @Test
    public void getUserByName(){
        User actual = userRepository.getUserByFirstName("Seppe");

        assertThat(actual).isEqualTo(seppe);
    }

    @Test
    public void getUserByName_NoUserFound(){
        assertThatThrownBy(()-> { userRepository.getUserByFirstName("Seppe2"); } ).isInstanceOf(NoResultException.class);
    }

    @Test
    public void getUserByName_NoUniqueUserFound(){
        entityManager.persist(aUser().withName("Seppe").withInns("1111111").build());

        assertThatThrownBy(()-> { userRepository.getUserByFirstName("Seppe"); } ).isInstanceOf(NonUniqueResultException.class);
    }

    @Test
    public void findUserByInss_ShouldReturnCorrectUser() throws Exception {
        assertThat(userRepository.findUserByInss("1223333")).isEqualTo(kiki);
    }

    @After
    public void teardown(){
        entityManager.clear();
    }

}