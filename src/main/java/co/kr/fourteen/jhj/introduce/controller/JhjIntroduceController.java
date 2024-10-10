package co.kr.fourteen.jhj.introduce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/jhj/introduce")
public class JhjIntroduceController {

	@RequestMapping(value = "/vision")
	public String helloMain() {
		return "jhj/introduce/vision";
	}
}
