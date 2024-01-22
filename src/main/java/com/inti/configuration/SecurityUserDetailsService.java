package com.inti.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inti.model.Utilisateur;
import com.inti.repository.IUtilisateurRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
	
	@Autowired
	IUtilisateurRepository iur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utilisateur u = iur.findByLogin(username);
		
		System.out.println("user : " + u);
		
		List<GrantedAuthority> listeGA = new ArrayList<GrantedAuthority>();
		listeGA.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return new User(u.getLogin(), u.getMdp(), listeGA);
	}

}
