package com.example.demo.Sevice;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.User;
import com.example.demo.dto.UserDto;

@Service
public interface UserService {
	User findByUsername(String username);
	User save(UserDto userDto);

}
