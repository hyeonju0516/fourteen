package co.kr.fourteen.jiyy.prac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.kr.fourteen.jiyy.prac.service.JyPracUserService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/jyprac")
@Slf4j
public class JyPracUserController {

	@Autowired
	private JyPracUserService jyPracUserService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String JyPracJoinView() {
		log.info("연습 join화면 진입");
		return "jiyy/prac/pracJoin";
	}

	/**
	 * @Method jyPracUserIdCheck
	 * @Date 2024.05.20
	 * @Writter jiYeon
	 * @Descipt 회원가입 아이디 중복체크
	 * @param userId
	 * @return ModelAndView
	 */

	@RequestMapping(value = "/userIdCheck", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView jyPracUserIdCheck(@RequestParam(name="userId") String userId){
		log.info("아이디중복체크 진입");
		log.info("userId::::"+ userId);
		ModelAndView mv = new ModelAndView("JSON_VIEW");

		boolean result = jyPracUserService.userIdCheck(userId);
		mv.addObject("check",result);

		return mv;
	}



}
