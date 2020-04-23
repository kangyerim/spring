package com.yerimspring.web.lotto;

import org.springframework.stereotype.Service;

@Service
public class LottoNumServiceImpl implements LottoNumService {
	private Lotto[] numbers;
	private int count;

	public LottoNumServiceImpl() {
		numbers = new Lotto[8];
		count = 0;
	}

	
	@Override
	public void buy(Lotto number) {
		String[] numbers = number.getLotto_number().split(",");
		for(int i = 0; i <count; i++) {
			number.setNum1(numbers[0]);
			number.setNum2(numbers[1]);
			number.setNum3(numbers[2]);
			number.setNum4(numbers[3]);
			number.setNum5(numbers[4]);
			number.setNum6(numbers[5]);
			add(number);
		}
	}
	
	private void add(Lotto number) {
		numbers[count]= number;
		count++;
	}
	
	@Override
	public int count() {
		return count;
	}

}
