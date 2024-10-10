package co.kr.fourteen.jiyy.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/jy")
public class CjyMainController {

	/**
	 * @Method cjyMainHome
	 * @Data 2024.05
	 * @Writter jiYeon
	 * @Description 메인 홈 출력
	 * @EditHistory 05.31 메인 페이지 강제 진입시 세션 정보 없으면 회원가입 페이지 리다이렉트 있으면 머물기
	 * @return String
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String cjyMainHome(HttpSession session, Model model) {
		//세션에서 사용자 정보 확인
		Object user = session.getAttribute("userId");
		log.info("session.getAttribute(\"userId\"):::>>>" + user);

		if (user == null) {
			return "redirect:/jy/join?redirected=true";
		}

		return "jiyy/main/jyMainHome";
	}

	/**
	 * @Method businessConduct
	 * @Data 2024.05.15
	 * @Writter jiYeon
	 * @Description 기업윤리 페이지 출력
	 * @EditHistory
	 * @return String
	 */
	@RequestMapping(value = "/businessConduct", method = RequestMethod.GET)
	public String businessConduct() {
		log.info(">>>>>news 진입");
		return "jiyy/main/jyBusinessConduct";
	}

}
