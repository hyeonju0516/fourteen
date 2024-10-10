package co.kr.fourteen.jhj.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.kr.fourteen.jhj.main.service.JhjMainSercive;
import co.kr.fourteen.jhj.user.vo.JhjUserVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/jhj/main")
public class JhjMainController {
	@Autowired
	private JhjMainSercive jhjMainService;

	/**
	 * @Method mainPage
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param HttpSession, Model
	 * @EditHistory
	 * @Discript 메인 페이지
	 * @return String
	 */
	@RequestMapping(value = "/mainPage")
	public String mainPage(HttpSession session, Model model) {
		JhjUserVo user = (JhjUserVo) session.getAttribute("user");
		if (user == null) {
			return "jhj/user/join";
		}
		model.addAttribute("user", user);
		return "jhj/main/main";
	}


	/**
	 * @Method checkSessionProcess
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param HttpSession
	 * @EditHistory
	 * @Discript ajax 세션 체크 처리
	 * @return Map<String, String>
	 */
	@RequestMapping(value = "/checkSessionProcess")
	@ResponseBody
	public Map<String, String> checkSessionProcess(HttpSession session) {
		Map<String, String> response = new HashMap<>();
		if (session.getAttribute("user") != null) {
			// 세션 있는 경우
			response.put("status","authenticated");
		} else {
			// 세션 없는 경우
			response.put("status","unauthenticated");
		}
		return response;
	}
}
