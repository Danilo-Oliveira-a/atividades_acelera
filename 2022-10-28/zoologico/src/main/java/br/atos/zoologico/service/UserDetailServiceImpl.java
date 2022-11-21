package br.atos.zoologico.service;

import br.atos.zoologico.model.UserModel;
import br.atos.zoologico.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;



@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	UserModel userModel = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não Encontrado" + username));
		
		return new User(userModel.getUsername(), userModel.getPassword(),true,true,true,true, userModel.getAuthorities() );
	}
	


}
