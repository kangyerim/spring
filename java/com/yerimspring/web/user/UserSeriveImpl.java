package com.yerimspring.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserSeriveImpl implements UserService {
	private Map<String,Object> map;
	
	public UserSeriveImpl() {
		map = new HashMap<>();
	}
	
	@Override
	public void add(User user) {
		map.put(user.getUserid(), user);
	}

	@Override
	public int count() {
		return map.size();
	}


}
