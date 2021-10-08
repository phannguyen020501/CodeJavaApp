package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("lethithuhieu");
		user.setPassword("thuhieu");
		user.setFirstName("thu");
		user.setLastName("hieu");
		
		User saveUser = repo.save(user);
		
		User existUser = entityManager.find(User.class, saveUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(saveUser.getEmail());
		
		
	}
	
	@Test
	public void testFindUserByEmail() {
		String email = "lethithuhieu";
		User user = repo.findByEmail(email);
		
		assertThat(user).isNotNull();
	}
}
