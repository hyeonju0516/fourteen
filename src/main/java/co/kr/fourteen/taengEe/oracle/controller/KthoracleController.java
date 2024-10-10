package co.kr.fourteen.taengEe.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.kr.fourteen.taengEe.oracle.service.KthoracleService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class KthoracleController {

	@Autowired
	private KthoracleService kthoracleService;

	@RequestMapping(value="/kthOracleView")
	public String kthOracleView(Model model) {

		log.info(">>>>>> 진입");

		String phone = kthoracleService.selectUserInfo("test");

		log.info(">>>>>> phone :: " + phone);
		model.addAttribute("result", phone);

		return "kth/oracle/kthOracleView";
	}

}
