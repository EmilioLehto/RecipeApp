package backend.project.cookingapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import backend.project.cookingapp.domain.User;
import backend.project.cookingapp.domain.UserRepository;

public class UserDetailServiceImpl implements UserDetailsService  {
	
	@Autowired
	UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = repository.findByUsername(username);
        if (currentUser == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                username, 
                currentUser.getPasswordHash(), 
                AuthorityUtils.createAuthorityList(currentUser.getRole())
        );
    }
}
