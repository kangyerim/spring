package com.yerimspring.web.member;

public class MemberServiceImpl implements MemberService {
	private Member[] members;
	private int count;

	public MemberServiceImpl() {
		members = new Member[5];
		count = 0;
	}

	@Override
	public void add(Member member) {
		members[count] = member;
		count++;
	}

	@Override
	public Member[] list() {
		return members;
	}

	@Override
	public Member[] searchByName(String name) {
		Member[] searchByName = null;
		int searchCount = count(name);
		if(searchCount != 0) {
			searchByName = new Member[searchCount];
			int j = 0;
			for(int i = 0; i < count; i++) {
				if(name.equals(members[i].getName())) {
					searchByName[j]=members[i];
					j++;
				}
				if(searchCount == j){
					break;
				}
			}
			
		}
		return searchByName;
	}

	@Override
	public Member detail(Member member) {
		Member detail = null;
		for (int i = 0; i < count; i++) {
			if (member.getUserid().equals(members[i].getUserid())) {
				detail = members[i];
			}
		}
		return detail;
	}

	@Override
	public Member login(Member member) {
		Member login = null;
		for (int i = 0; i < count; i++) {
			if (member.getUserid().equals(members[i].getUserid())
					&& member.getPassword().equals(members[i].getPassword())) {
				login = members[i];

			}
		}
		return login;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public int count(String name) {
		int count = 0;
		for (int i = 0; i < this.count; i++) {
			if (name.equals(members[i].getName())) {
				count++;
			}
		}
		return count;
	}

	@Override
	public void update(Member member) {
		for (int i = 0; i < count; i++) {
			if (member.getUserid().equals(members[i].getUserid())) {
				members[i].setPassword(member.getPassword());
				break;
			}
		}
	}

	@Override
	public void delete(Member member) {
		for (int i = 0; i < count; i++) {
			if (member.getUserid().equals(members[i].getUserid())
					&& member.getPassword().equals(members[i].getPassword())) {
				members[i] = members[count - 1];
				members[count - 1] = null;
				count--;
			}
		}
	}

}
