package com.yerimspring.web.member;

public interface MemberService {
	public void add(Member member);

	public Member[] list();

	public Member[] searchByName(String name);

	public Member detail(Member member);

	public int count();

	public boolean login(Member member);

	public int count(String name);

	public void update(Member member);

	public void delete(Member member);
}
