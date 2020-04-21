package com.yerimspring.web.grade;

import org.springframework.stereotype.Service;

import com.yerimspring.web.util.GradeCredit;

@Service
public class GradeServiceImpl implements GradeService {
	private Grade[] grades;
	private int count;

	public GradeServiceImpl() {
		grades = new Grade[4];
		count = 0;
	}

	@Override
	public void add(Grade grade) {
		grades[count] = grade;
		count++;
	}

	@Override
	public Grade[] list() {
		return grades;
	}

	@Override
	public Grade detail(Grade grade) {
		Grade detail = null;
		return detail;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public int total(Grade grade) {

		return Integer.parseInt(grade.getKorean()) + Integer.parseInt(grade.getEnglish())
				+ Integer.parseInt(grade.getMath()) + Integer.parseInt(grade.getJava());
	}

	@Override
	public int average(Grade grade) {
		return total(grade) / 4;
	}

	@Override
	public GradeCredit credit(Grade grade) {

		GradeCredit result = null;

		int i = average(grade) / 10;
		switch (i) {
		case 10:
			result = GradeCredit.A;
			break;
		case 9:
			result = GradeCredit.A;
			break;
		case 8:
			result = GradeCredit.B;
			break;
		case 7:
			result = GradeCredit.C;
			break;
		case 6:
			result = GradeCredit.D;
			break;
		case 5:
			result = GradeCredit.F;
			break;
		}
		return result;
	}

	@Override
	public void update(Grade grade) {

	}

	@Override
	public void delete(Grade grade) {

	}

}
