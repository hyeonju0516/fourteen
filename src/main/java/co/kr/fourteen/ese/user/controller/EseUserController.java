package co.kr.fourteen.ese.user.controller;


import co.kr.fourteen.common.mail.service.MailService;
import co.kr.fourteen.common.util.Rsa;
import co.kr.fourteen.ese.user.service.EseUserService;
import co.kr.fourteen.ese.user.vo.EseUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.PrivateKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping(value="/ese/user/")
public class EseUserController {


	@Autowired
	private EseUserService eseUserService;

	@Autowired
	private MailService mailService;

	private static String sendEmailId = "djandcl@gmail.com";

	/**
	* @Method eseJoin
	* @Date 2024. 05. 18.
	* @Writter ese(어성은 )
	* @EditHistory
	* @param HttpServletRequest
	* @Discript Seongeun Join Page.
	* @Return ModelAndView
	*/
	@RequestMapping(value="joinPage", method = RequestMethod.GET) // 주소호출
	public ModelAndView eseJoin(HttpServletRequest req) {
		log.info(">>>>>eseJoin진입");
		//RSA키 생성
		Rsa rsa = new Rsa();
		rsa.initRsa(req, "web");
		ModelAndView mv = new ModelAndView("ese/user/join");
		return mv;
	}

	/**
	* @Method doubleCheckId
	* @Date 2024. 05. 18.
	* @Writter ese(어성은 )
	* @EditHistory
	* @Discript Seongeun Join 아이디 중복확인
	* @param String
	* @Return ModelAndView
	*/

	@RequestMapping(value="doubleCheckId")
	@ResponseBody
	public ModelAndView doubleCheckId(@RequestParam String userId) {
		log.info(">>>>>userId" + userId);
		log.info(">>>>>doubleCheckId진입");
		ModelAndView mv = new ModelAndView("JSON_VIEW");

		boolean result = eseUserService.doubleCheckId(userId);
		mv.addObject("result", result);
		return mv;
	}


	/**
	* @Method insertInfo
	* @Date 2024. 05. 25.
	* @Writter ese(어성은 )
	* @EditHistory
	* @Discript Seongeun Join 회원가입(C)
	* @param String
	 * @throws Exception
	* @Return ResponseEntity<String>
	*/

	@RequestMapping(value = "insertInfo", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView insertInfo(EseUserVo info, HttpServletRequest req) throws Exception {
		ModelAndView mv = new ModelAndView("JSON_VIEW");
		eseUserService.insertInfo(info, req);

		// 회원가입 메일 발송
		String subject = "회원가입";
		StringBuilder sb = new StringBuilder();
		sb.append("정상적으로 회원가입 완료입니다.");
		mailService.send(subject, sb.toString(), sendEmailId, info.getUserEmail() + "@" + info.getUserDomail(), null);

		return mv;
	}




}
