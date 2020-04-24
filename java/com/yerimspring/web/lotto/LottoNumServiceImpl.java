package com.yerimspring.web.lotto;

import java.util.Random;

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
	public void add(Lotto number) {
		numbers[count] = number;
		count++;
	}

	@Override
	public int count() {
		return count;
	}

	@SuppressWarnings("unused")
	private String splitNumbers(Lotto number) {
		String[] buyLotto = String.valueOf(number).split(",");
		return buyLotto[count];
	}
	
	private Random randomNumbers(Lotto number) {
		Random randomNumbers = new Random();
		
		return randomNumbers;
	}
}
