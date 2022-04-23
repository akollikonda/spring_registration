package com.abhilash.demo.appUser;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService{

	private AppUserRepository appUserRepository;
	private final static String USER_NOT_FOUND="User  with this email %s not found";
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return appUserRepository.findByEmail(username).orElseThrow(
				()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
	}

}
