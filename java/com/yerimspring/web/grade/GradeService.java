package com.yerimspring.web.grade;

import com.yerimspring.web.util.GradeCredit;

public interface GradeService {
	public void add(Grade grade);
	public Grade[] list();
	public int count();
	public GradeCredit detail(String userid);
	public void update(Grade grade);
	public void delete(Grade grade);
}
