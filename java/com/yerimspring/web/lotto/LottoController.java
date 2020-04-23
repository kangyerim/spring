package com.yerimspring.web.lotto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yerimspring.web.util.Messenger;

@RestController
@RequestMapping("/lotto")
public class LottoController {
	@Autowired LottoNumService lottoNumService;

	@PostMapping("/buy")
	public Messenger buy(@RequestBody Lotto number) {
		System.out.println(">>>>>>>>>>"+buy(number));
		int current = lottoNumService.count();
		lottoNumService.buy(number);
		return (lottoNumService.count() == (current+1))? Messenger.Success : Messenger.FAIL;
	}
	
}
