package com.yerimspring.web.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yerimspring.web.util.GradeCredit;
import com.yerimspring.web.util.Messenger;

@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired GradeService gradeService;

	@PostMapping("/add")
	public Messenger add(@RequestBody Grade grade) {
		int current = gradeService.count();
		gradeService.add(grade);
		return (gradeService.count() == (current + 1)) ? Messenger.Success : Messenger.FAIL;
	}

	@GetMapping("/credit/{userid}")
	public GradeCredit credit(@PathVariable String userid) {
		return gradeService.detail(userid);
	}

}
