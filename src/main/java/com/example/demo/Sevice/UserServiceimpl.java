package com.example.demo.Sevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.UserDto;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	PasswordEncoder passwordEncoder;

	private UserRepository userRepository;
	
	
	public UserServiceimpl(UserRepository userrepository) {
		
		this.userRepository = userrepository;
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(UserDto userDto) {
		User user= new User(userDto.getUsername(),passwordEncoder.encode(userDto.getPassword()),userDto.getFullname());
		return userRepository.save(user);
	}
	
	

}
