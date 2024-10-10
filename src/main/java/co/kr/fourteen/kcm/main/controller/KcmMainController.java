package co.kr.fourteen.kcm.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class KcmMainController {

	/**
	 * @Method kcmMain
	 * @Date 2024. 06. 06
	 * @Writter KCM
	 * @EditHistory
	 * @Discript 메인페이지 진입
	 * @Return String
	 */
	@RequestMapping(value="/kcmMain", method = RequestMethod.GET) // 주소호출
	public String kcmMain(HttpSession session) {
		log.info(">>>>>진입1111");

//		if (session.getAttribute("loginUser") == null) {
//			return "redirect:/kcm/login/login";
//		}

		return "kcm/main/main";
	}

}
