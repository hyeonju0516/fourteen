package co.kr.fourteen.hoseong.khs.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping(value = "/khs/")
public class KhsController {

	/**
	* @Method hsMain
	* @Date 2024. 05. 04.
	* @Writter gak098(곽호성)
	* @EditHistory
	* @Discript HoSeong Main Page.
	* @Return String
	*/
	@RequestMapping(value="hsMain", method = RequestMethod.GET)
	public String hoBoard(HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		if (!StringUtils.hasText(userId)) {
			return "redirect:/khsLogin/login";
		}

		return "hoseong/khs/hsMain";
	}

	/**
	 * @Method AboutUs
	 * @Date 2024. 05. 13.
	 * @Writter gak098(곽호성)
	 * @EditHistory
	 * @Discript 회사소개 Page.
	 * @Return String
	 */
	@RequestMapping(value="aboutUs", method = RequestMethod.GET)
	public String AboutUs() { return "hoseong/khs/aboutUs"; }

}
