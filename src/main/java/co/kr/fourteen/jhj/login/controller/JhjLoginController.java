package co.kr.fourteen.jhj.login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.kr.fourteen.jhj.login.service.JhjLoginService;
import co.kr.fourteen.jhj.user.vo.JhjUserVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/jhj/login")
public class JhjLoginController {
	@Autowired
	private JhjLoginService jhjLoginService;

	/**
	 * @Method loginPage
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param
	 * @EditHistory
	 * @Discript 로그인 페이지
	 * @return String
	 */
	@RequestMapping(value = "/loginPage")
	public String loginPage() {
		return "jhj/login/login";
	}


	/**
	 * @Method loginProcess
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param JhjUserVo, HttpSession
	 * @EditHistory
	 * @Discript ajax 로그인 처리
	 * @return Map<String, String>
	 */
	@RequestMapping(value = "/loginProcess")
	@ResponseBody
	public Map<String, String> loginProcess(JhjUserVo inputVo, HttpSession session) {
		Map<String, String> response = new HashMap<>();

		JhjUserVo loginVo = jhjLoginService.selectJhjUserPw(inputVo);
		String hashedPassword = BCrypt.hashpw(inputVo.getUserPw(), BCrypt.gensalt());
		boolean isValid = BCrypt.checkpw(inputVo.getUserPw(), hashedPassword);

		if (isValid) {
			session.setAttribute("user", inputVo);
			response.put("status", "authenticated");
			response.put("redirect","/jhj/main/mainPage");
		} else {
			response.put("status", "unauthenticated");
			response.put("redirect","/jhj/login/loginPage");
		}
		return response;
	}


	/**
	 * @Method loginProcess
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param
	 * @EditHistory
	 * @Discript google otp 팝업 페이지
	 * @return String
	 */
	@RequestMapping(value = "/googleOtpPop")
	public String googleOtpPop() {
		return "jhj/login/poup/googleOtpPop";
	}

	/**
	 * @Method pwResetPop
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param
	 * @EditHistory
	 * @Discript 비밀번호 초기화 팝업 페이지
	 * @return String
	 */
	@RequestMapping(value = "/pwResetPop")
	public String pwResetPop() {
		return "jhj/login/popup/pwResetPop";
	}

	/**
	 * @Method pwResetProcess
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param JhjUserVo
	 * @EditHistory
	 * @Discript ajax 비밀번호 초기화 처리
	 * @return Map<String, String>
	 */
	@RequestMapping(value = "/pwResetProcess")
	@ResponseBody
	public Map<String, String> pwResetProcess(JhjUserVo vo) {
		Map<String, String> response = jhjLoginService.resetPw(vo);
		return response;
	}

	/**
	 * @Method findIdPop
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param
	 * @EditHistory
	 * @Discript 아이디 찾기 팝업 페이지
	 * @return String
	 */
	@RequestMapping(value = "/findIdPop")
	public String findIdPop() {
		return "jhj/login/popup/findIdPop";
	}

	/**
	 * @Method findIdProcess
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param JhjUserVo
	 * @EditHistory
	 * @Discript ajax 아이디 찾기 처리
	 * @return Map<String, String>
	 */
	@RequestMapping(value = "/findIdProcess")
	@ResponseBody
	public Map<String, String> findIdProcess(JhjUserVo vo) {
		Map<String, String> response = jhjLoginService.findId(vo);
		log.info("당신의 아이디는 : " + response.get("idList"));
		return response;
	}

	/*
	 * 아이디 찾기 결과 리턴
	 */
	/**
	 * @Method findIdResultPop
	 * @Date 2024. 06. 12.
	 * @Writter jhj(조현준)
	 * @param String, Model
	 * @EditHistory
	 * @Discript 아이디 찾기 결과 페이지
	 * @return String
	 */
	@RequestMapping(value = "/findIdResultPop")
	public String findIdResultPop(@RequestParam("idList") String idList, Model model) {
		model.addAttribute("idList", idList);
		return "jhj/login/popup/findIdResultPop";
	}

}
