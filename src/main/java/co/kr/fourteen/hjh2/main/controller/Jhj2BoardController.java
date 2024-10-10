package co.kr.fourteen.hjh2.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/jhj2/board")
public class Jhj2BoardController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String board() {
		return "jhj2/board/board";
	}

}
