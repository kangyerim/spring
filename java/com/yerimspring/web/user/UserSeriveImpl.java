package com.yerimspring.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class UserSeriveImpl implements UserService {
	private Map<String, Object> map;
	public final static String FILE_PATH = "C:\\Users\\bit\\Documents\\workspace-spring-tool-suite-4-4.6.0.RELEASE\\yerimspring\\src\\main\\resources\\static\\user\\";

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

	@Override
	public List<User> list() {
		List<User> list = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		Set set = map.entrySet();
		@SuppressWarnings("rawtypes")
		Iterator it = set.iterator();
		while(it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, User> e = (Entry<String, User>) it.next();
			list.add(e.getValue());
		}

		return list;
	}

	@Override
	public void saveFile(User user) {
		try {
			File file = new File(FILE_PATH + "list.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
					String messege = user.toString();
					writer.write(messege);
					writer.newLine();
					writer.flush(); //보내기
			
		} catch(Exception e) {
			System.out.println("파일 쓰기에서 에러발생");
		}
		
	}

	@Override
	public List<User> readFile() {
		List<User> userList = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			File file = new File(FILE_PATH + "list.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String messege = "";
					while((messege = reader.readLine()) != null) {
						list.add(messege);
					}
					reader.close(); //닫기
		} catch(Exception e) {
			System.out.println("파일 읽기에서 에러 발생");
		}
		User u = null;
		for(int i = 0; i < list.size(); i++) {
			u = new User();
			String[] arr = list.get(i).split(",");
			u.setUserid(arr[0]);
			u.setPassword(arr[1]);
			u.setName(arr[2]);
			u.setSsn(arr[3]);
			u.setAddress(arr[4]);
			userList.add(u);
		}
		return userList;
	}

	@Override
	public boolean idCheck(String userid) {
		// TODO Auto-generated method stub
		return false;
	}

}
