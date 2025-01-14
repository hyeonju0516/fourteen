package co.kr.fourteen.seHyun.oracle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class YshOracleController {

	@RequestMapping(value="/yshOracleView", method=RequestMethod.GET)
	public String yshOracleView() {

		log.info("yshOracleView진입***");

		return "ysh/oracle/yshOracleView";
	}

}
