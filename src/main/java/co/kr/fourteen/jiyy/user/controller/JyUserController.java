package co.kr.fourteen.jiyy.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.kr.fourteen.jiyy.user.service.JyUserService;
import co.kr.fourteen.jiyy.user.vo.JyUserVo;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/jy")
@Slf4j
public class JyUserController {

	@Autowired
	private JyUserService jyUserService;

	@RequestMapping(value ="/join", method = RequestMethod.GET)
	public String jyJoinVeiw() {
		log.info("join진입");
		return "jiyy/user/jyJoin";
	}

	/**
	 * @Method userIdCheck
	 * @Date 2024.05
	 * @Writter JiYeon
	 * @Descript userId 중복Check
	 * @param userId
	 * @return ModelAndView
	 */

	@RequestMapping(value = "/userIdCheck", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView userIdCheck(@RequestParam(name="userId") String userId) {
		log.info("userIdCheck 진입");
		log.info("userIdCheck::::"+ userId);
		ModelAndView mv = new ModelAndView("JSON_VIEW");
		boolean result = jyUserService.userIdCheck(userId);
		mv.addObject("result",result);
		return mv;
	}

	/**
	 * @Method userJoinData
	 * @Date 2024.05.28
	 * @Writter JiYeon
	 * @Descript userJoinData 보내기
	 * @param userData
	 * @return String
	 */

	@RequestMapping(value = "/userJoin", method = RequestMethod.POST)
	@ResponseBody
	public String userJoinData(JyUserVo userData) {// 인풋에서 넣어준 데이터를 vo에 넣어서 보내줌.
		log.info("userJoinData:::::"+ userData);

		jyUserService.userJoinData(userData);
		return "성공";
	}

	/**
	 * @Method userLogin
	 * @Date 2024.05.31
	 * @Writter JiYeon
	 * @Desctipt 로그인페이지 출력
	 * @return String
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLogin() {
		log.info(">>>>>>로그인페이지 출력");
		return "jiyy/user/jylogin";
	}

	/**
	 * @Method userLoinCheck
	 * @Date 2024.05.31
	 * @Writter JiYeon
	 * @Desctipt 회원로그인
	 * @param userLoginDt
	 * @return JyUserVo
	 */

	@RequestMapping(value = "/userLogin/post", method = RequestMethod.POST)
	@ResponseBody
	public JyUserVo userLoinCheck(JyUserVo userLoginDt, HttpSession session) {
		log.info("userLoginCheck:::::::" + userLoginDt);
		JyUserVo result = jyUserService.userLoginCheck(userLoginDt);

		if(result != null) {
			session.setAttribute("userId", result.getUserId());
			log.info("result::::::::::"+ result);
		}

;		return result;
	}


	/**
	 * @Method userLogOut
	 * @Date 2024.05.31
	 * @Writter JiYeon
	 * @Descript 유저로그아웃
	 * @param session
	 * @return String
	 */

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String userLogOut(HttpSession session) {

		session.removeAttribute("userId");
		return "redirect:/jy/login";
	}
}
