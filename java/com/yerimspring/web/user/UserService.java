package com.yerimspring.web.user;

public interface UserService {
	public void add(User user);

	public int count();

	public User signin(User user);
	
	public User detail(String userid);

	public boolean update(User user);

	public boolean remove(String userid);

}
