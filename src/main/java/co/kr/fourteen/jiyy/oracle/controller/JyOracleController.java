package co.kr.fourteen.jiyy.oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.fourteen.jiyy.oracle.service.JyOracleService;
import co.kr.fourteen.jiyy.oracle.vo.JyOracleVo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value="/jyOracle")
public class JyOracleController {

	@Autowired
	private JyOracleService jyOracleService;

	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String jyOracleMain() {

		return "jiyy/oracle/jyOracleMain";
	}

	@RequestMapping(value="/view", method = RequestMethod.GET)
	public String jyOracleView() {
		log.info(">>>>> 첫진입");

		return "jiyy/oracle/jyOracleView";
	}

	@RequestMapping(value="/result", method = RequestMethod.GET)
	public String jyOracleResult(HttpServletRequest httpServletRequest, Model model) {
		log.info("데이터 받는 곳 진입");

		String userNo = httpServletRequest.getParameter("userNo");
		//name값으로 가져옴
		String phone = jyOracleService.selectUserInfo(userNo);
		log.info("phone::" + phone);
		model.addAttribute("result",phone);

		return "jiyy/oracle/cjyOracleView";
	}

	@RequestMapping(value="/form", method = RequestMethod.GET)
	public String jyOracleForm() {
		log.info("폼 진입");

		return "jiyy/oracle/jyOracleForm";
	}

	@RequestMapping(value="/addInfo", method = RequestMethod.POST)
	public String addInfo(JyOracleVo vo) {
		//Vo를 쓰기위해 import 해야함
		log.info("add진입");
		log.info("받은데이터::"+vo);

		jyOracleService.addInfo(vo);
		return "jiyy/oracle/jyOracleMain";
	}

	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String jyOracleTest(Model model) {
		log.info("test 진입");

		String test = jyOracleService.selectUserID("YANG");
		log.info("id:::" + test);
		model.addAttribute("result",test);

		return "jiyy/oracle/test";
	}

}
