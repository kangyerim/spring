package com.yerimspring.web.grade;

import com.yerimspring.web.util.GradeCredit;

public interface GradeService {
	public void add(Grade grade);
	public Grade[] list();
	public Grade detail(Grade grade);
	public int count();
	public int total(Grade grade);
	public int average(Grade grade);
	public GradeCredit credit(Grade grade);
	public void update(Grade grade);
	public void delete(Grade grade);
}
