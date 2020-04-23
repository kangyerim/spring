package com.yerimspring.web.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yerimspring.web.util.Messenger;

@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired MemberService memberService;

	@PostMapping("/join")
	public Messenger add(@RequestBody Member member) {
		int current = memberService.count();
		memberService.add(member);
		return (memberService.count() == (current +1))? Messenger.Success : Messenger.FAIL;
	}

	@PostMapping("/login")
	public Messenger login(@RequestBody Member member) {
		return (memberService.login(member)) ? Messenger.Success : Messenger.FAIL;
	}

	@GetMapping("/list")
	public Member[] list() {
		Member[] returnMembers = new Member[5];
		memberService.list();
		return returnMembers;
	}

	@GetMapping("/detail")
	public Member detail(@RequestBody Member member) {
		Member returnMember = new Member();
		return returnMember;
	}

	@GetMapping("/count")
	public int count() {
		int count = 0;
		return count;
	}

	@PutMapping("/update")
	public Member update(@RequestBody Member member) {
		Member returnMember = new Member();
		return returnMember;
	}

	@DeleteMapping("/delete")
	public Member delete(@RequestBody Member member) {
		Member returnMember = new Member();
		return returnMember;
	}
}
