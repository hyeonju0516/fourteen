package co.kr.fourteen.chaesong.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.fourteen.chaesong.main.service.YcsMainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequiredArgsConstructor
@Slf4j
public class YcsMainController {
	private final YcsMainService ycsMainService;

	@RequestMapping(value="/chaesong", method={RequestMethod.GET, RequestMethod.POST})
	public String jyOracleView(Model model) {

		log.info(">>>>> 진입");

		String phone = ycsMainService.selectUserInfo("윤채송2");

		log.info("phone :: " + phone);
		model.addAttribute("result", phone);

		return "chaesong/main/hapbbieMainInsert";
	}
}
