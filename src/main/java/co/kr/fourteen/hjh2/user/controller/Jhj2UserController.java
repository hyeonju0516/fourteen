package co.kr.fourteen.hjh2.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.kr.fourteen.hjh2.user.service.Jhj2UserService;
import co.kr.fourteen.hjh2.user.vo.Jhj2UserInfoVo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value="/jhj2/user/")
public class Jhj2UserController {

	@Autowired
	private Jhj2UserService userService;

	@RequestMapping(value="join", method = RequestMethod.GET)
	public String getJoin() {
		return "jhj2/user/join";
	}

	@RequestMapping(value="join", method = RequestMethod.POST)
	@ResponseBody
	public boolean postJoin(Jhj2UserInfoVo user) {
		log.info("user >>>>>>>>>>> "+user);
		return userService.userJoin(user);
	}

	@RequestMapping(value="doubleCheckId")
	@ResponseBody
	public boolean doubleCheckId(@RequestParam String userId) {
		log.info("*******userId = "+userId);
		return userService.doubleCheckId(userId);
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLogin() {
		return "jhj2/user/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Jhj2UserInfoVo postLogin(Jhj2UserInfoVo user, HttpSession session) {
		user = userService.userLogin(user.getUserId(), user.getUserPw());
		session.setAttribute("loginUser", user);
		return user;
	}
}
