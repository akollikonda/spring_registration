package com.abhilash.demo.appUser;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor

@Entity
public class AppUser implements UserDetails {

	
	@Id
	@SequenceGenerator(
		name = "student_sequence",
		sequenceName="student_sequence",
		allocationSize=1
		
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "student_sequence"
	)
	private long id;
	
	private String name;
	private String userName;
	private String password;
	private String email;
	@Enumerated(EnumType.STRING)
	private  AppUserRole appUserRole;
	private boolean locked;
	private boolean enabled;
	
	
	
	public AppUser(String name, String userName, String password, String email, AppUserRole appUserRole, boolean locked,
			boolean enabled) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.appUserRole = appUserRole;
		this.locked = locked;
		this.enabled = enabled;
	}

	@Override
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority =new SimpleGrantedAuthority(appUserRole.name());
		return Collections.singletonList(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

}
