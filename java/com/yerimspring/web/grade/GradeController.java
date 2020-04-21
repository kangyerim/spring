package com.yerimspring.web.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yerimspring.web.member.MemberService;
import com.yerimspring.web.util.GradeCredit;
import com.yerimspring.web.util.Messenger;

@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired GradeService gradeService;

	@PostMapping("/add")
	public Messenger add(@RequestBody Grade grade) {
		System.out.println("tset");
		int current = gradeService.count();
		gradeService.add(grade);
		System.out.println(grade);
		return (gradeService.count() == (current + 1)) ? Messenger.Success : Messenger.FAIL;
	}

	@PostMapping("/credit")
	public GradeCredit credit(@RequestBody Grade grade) {
		GradeCredit credit = gradeService.credit(grade);
		return credit;
	}

}
