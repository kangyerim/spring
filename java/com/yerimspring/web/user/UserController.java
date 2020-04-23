package com.yerimspring.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yerimspring.web.util.Messenger;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired UserService userService;
	
	@PostMapping("/signup")
	public Messenger signup(@RequestBody User user) {
		int count = userService.count();
		userService.add(user);
		return (userService.count() == (count + 1))? Messenger.Success : Messenger.FAIL;
	}
}
