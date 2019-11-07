package com.aereas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aereas.domain.Passageiro;
import com.aereas.repository.PassageiroRepository;
import com.aereas.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PassageiroRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Passageiro passageiro = repo.findByLoginUser(username);
		if (passageiro == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserSS(passageiro.getId(), passageiro.getEmail(), passageiro.getPassword(), passageiro.getPerfis());
	}
}