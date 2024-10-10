package co.kr.fourteen.kcm.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.kr.fourteen.common.mail.service.MailService;
import co.kr.fourteen.common.util.Rsa;
import co.kr.fourteen.kcm.user.service.KcmUserService;
import co.kr.fourteen.kcm.user.vo.KcmUserInfoVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/kcm/user/")
public class KcmUserController {

	@Autowired
	private KcmUserService kcmUserService;

	@Autowired
	private MailService mailService;

	private static String sendEmailId = "hazedensays@naver.com";

	/**
	 * @Method kcmJoin
	 * @Date 2024. 06. 06
	 * @Writter KCM
	 * @EditHistory
	 * @Discript 회원가입 페이지 진입
	 * @Return String
	 */
	@RequestMapping(value="join", method = RequestMethod.GET) // 주소호출
	public String kcmJoin(HttpServletRequest req) {
		Rsa rsa = new Rsa();
		//임시 에러해결
		rsa.initRsa(req, "web");
		return "kcm/user/join";
	}

	/**
	 * @Method doubleCheckId
	 * @Date 2024. 06. 06
	 * @Writter KCM
	 * @EditHistory
	 * @Discript 아이디 중복체크
	 * @Return boolean
	 */
	@RequestMapping(value="doubleCheckId")
	@ResponseBody
	public boolean doubleCheckId(@RequestParam String userId) {
		log.info(">>>>>>> userId :: " + userId);
		return kcmUserService.doubleCheckId(userId);
	}

	/**
	 * @Method kcmJoinPost
	 * @Date 2024. 06. 06
	 * @Writter KCM
	 * @EditHistory
	 * @Discript 회원가입
	 * @Return boolean
	 */
	@RequestMapping(value="join", method = RequestMethod.POST)
	@ResponseBody
	public boolean kcmJoinPost(KcmUserInfoVo vo, HttpServletRequest req) throws Exception {
		log.info("join Vo ====> " + vo);
		kcmUserService.userJoin(vo, req);

		String subject = "[회원가입]" + vo.getUserNm() + "님, 회원가입이 완료되었습니다.";
		StringBuilder sb = new StringBuilder();
		sb.append("정상적으로 회원가입 완료입니다.");
		mailService.send(subject, sb.toString(), sendEmailId, vo.getUserEmail() + "@" + vo.getUserDomail(), null);

		return kcmUserService.userJoin(vo, req);
	}

}
