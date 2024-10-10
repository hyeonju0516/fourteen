package co.kr.fourteen.jhj.user.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.kr.fourteen.common.mail.service.MailService;
import co.kr.fourteen.jhj.user.service.JhjUserService;
import co.kr.fourteen.jhj.user.vo.JhjUserVo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/jhj/user")
public class JhjUserController {
	@Autowired
	private JhjUserService JhjUserSercive;

	@Autowired
	@Qualifier("mailServiceImpl")
	private MailService MailService;

	/**
	 * @Method joinPage
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param
	 * @EditHistory
	 * @Discript 회원가입페이지
	 * @return String
	 */
	@RequestMapping(value = "/joinPage")
	public String joinPage() {
		return "jhj/user/join";
	}


	/**
	 * @Method doubleCHeckId
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param String
	 * @EditHistory
	 * @Discript 아이디 중복체크
	 * @return ModelAndView
	 */
	@RequestMapping(value = "doubleCheckId")
	@ResponseBody
	public ModelAndView doubleCHeckId(@RequestParam String userId) {
		ModelAndView mv = new ModelAndView("JSON_VIEW");
		boolean result = JhjUserSercive.doubleCheckUser(userId);
		mv.addObject("result", result);
		return mv;
	}

	/**
	 * @Method joinProcess
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param JhjUserVo
	 * @EditHistory
	 * @Discript ajax 회원가입 처리
	 * @return String
	 */
	@RequestMapping(value = "/joinProcess", method = RequestMethod.POST)
	@ResponseBody
	public String joinProcess(JhjUserVo vo) {
		String hashedPassword = BCrypt.hashpw(vo.getUserPw(), BCrypt.gensalt());
		vo.setUserPw(hashedPassword);
		vo.setUserMail(vo.getUserEmail() + "@" + vo.getUserDomail());
		JhjUserSercive.insertJhjUserJoin(vo);
		MailService.send("회원가입을 축하합니다.", vo.getUserNm()+"님, 회원가입을 축하합니다.", "jjohyhy@gmail.com", vo.getUserMail(), "");
		return "통과";
	}

}

