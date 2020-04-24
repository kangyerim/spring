package com.yerimspring.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserSeriveImpl implements UserService {
	private Map<String, Object> map;

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

	@Override
	public User signin(User user) {
		User returnUser = null;
		if (map.containsKey(user.getUserid())) {
			User u = detail(user.getUserid());
			if (user.getPassword().equals(u.getPassword())) {
				returnUser = u;
			}
		}
		return returnUser;
	}

	@Override
	public User detail(String userid) {
		User t = (User) map.get(userid);
		return t;
	}

	@Override
	public boolean update(User user) {
		map.replace(user.getUserid(), user);
		return true;
	}

	@Override
	public boolean remove(String userid) {
		map.remove(userid);
		return true;
	}

}
