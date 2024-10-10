package co.kr.fourteen.cjy.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CjyMainController {

	@RequestMapping(value="/cjymain/view", method = RequestMethod.GET)
	public String jyMainView(Model model) {

		log.info("메인 진입");
		return "jiyy/main/cjyMainView";
	}
}
