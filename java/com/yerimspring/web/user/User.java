package com.yerimspring.web.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	private String userid, password, name, ssn, address;
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s", userid, password, name, ssn, address);
	}
	
}
