package com.yerimspring.web.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		userService.saveFile(user);
		//return (userService.count() == (count + 1))? Messenger.Success : Messenger.FAIL;
		return Messenger.Success;
	}
	
	@GetMapping("/list")
	public List<User> list(){
		//return userService.list();
		return userService.readFile();
	}
	
	@GetMapping("/idCheck/{userid}")
	public Messenger idCheck(@PathVariable String userid){
		return (userService.idCheck(userid))? Messenger.Success : Messenger.FAIL;
	}
	
	@PostMapping("/signin")
	public Map<String,Object> signin(@RequestBody User user) {
		Map<String,Object> returnMap = new HashMap<>();
		User signinedUser = userService.signin(user);
		if(signinedUser != null) {
			returnMap.put("user", signinedUser);
			returnMap.put("messenger", Messenger.Success);
		} else {
			returnMap.put("messenger", Messenger.FAIL);
		}
		return returnMap;
	}
	
	@GetMapping("detail/{userid}")
	public User detail(@PathVariable String userid) {
		return userService.detail(userid);
	}
	
	@PutMapping("/update")
	public Messenger update(@RequestBody User user) {
		return (userService.update(user))? Messenger.Success : Messenger.FAIL ;
	}
	
	@DeleteMapping("/remove/{userid}")
	public Messenger remove(@PathVariable String userid) {
		return (userService.remove(userid)) ? Messenger.Success : Messenger.FAIL;
	}
}
