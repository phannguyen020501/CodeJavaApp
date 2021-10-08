package net.codejava;

import java.nio.file.attribute.UserDefinedFileAttributeView;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new CustomerUserDetails(user);
	}
	
}
