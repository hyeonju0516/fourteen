package co.kr.fourteen.cyj.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.kr.fourteen.common.mail.service.MailService;
import co.kr.fourteen.common.util.Rsa;
import co.kr.fourteen.cyj.user.service.CyjUserService;
import co.kr.fourteen.cyj.user.vo.CyjUserVo;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="/cyj/user/")
@Slf4j
public class CyjUserController{

	@Autowired
	private CyjUserService cyjUserService;

	@Autowired
	private MailService mailService;

	private static String sendEmailId = "remember9659@gmail.com";

	/**
	 * @Method userJoinPage
	 * @Date 2024. 06. 05.
	 * @Writter sky(정영진)
	 * @Param HttpServletRequest
	 * @EditHistory
	 * @Discript 회원가입 페이지.
	 * @Return ModelAndView
	 */

	@RequestMapping(value="userJoinPage", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView userJoinPage(HttpServletRequest req) {
		//RSA키 생성
		Rsa rsa = new Rsa();
		rsa.initRsa(req, "web");
		ModelAndView mv = new ModelAndView("cyj/user/userJoin");
		return mv;
	}

	/**
	 * @Method doubleCheckId
	 * @Date 2024. 06. 05.
	 * @Writter sky(정영진)
	 * @Param String
	 * @EditHistory
	 * @Discript 중복 아이디 체크.
	 * @Return ModelAndView
	 */

	@RequestMapping(value="doubleCheckId", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ModelAndView doubleCheckId(@RequestParam String userId) {
		log.info(">>>>>>> userId :: " + userId);
		ModelAndView mv = new ModelAndView("JSON_VIEW");
		boolean result = cyjUserService.doubleCheckId(userId);
		mv.addObject("result", result);
		return mv;
	}

	/**
	 * @Method userJoin
	 * @Date 2024. 06. 05.
	 * @Writter sky(정영진)
	 * @Param CyjUserVo
	 * @Param HttpServletRequest
	 * @EditHistory
	 * @Discript 회원가입 처리.
	 * @Return ModelAndView
	 */

	@RequestMapping(value="userJoin", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView userJoin(CyjUserVo userVo, HttpServletRequest req) throws Exception {
		ModelAndView mv = new ModelAndView("JSON_VIEW");
		log.info(">>>>>>> userVo :: " + userVo.toString());
		cyjUserService.userJoin(userVo, req);
		String subject = "회원가입";
		StringBuilder sb = new StringBuilder();
		sb.append("정상적으로 회원가입 완료입니다.");
		mailService.send(subject, sb.toString(), sendEmailId, userVo.getUserEmail() + "@" + userVo.getUserDomail(), null);
		return mv;
	}
}
