package co.kr.fourteen.ese.login.controller;


import co.kr.fourteen.common.util.FrontBackErrorCode;
import co.kr.fourteen.common.util.GoogleOtp;
import co.kr.fourteen.common.util.IpUtil;
import co.kr.fourteen.common.util.Rsa;
import co.kr.fourteen.ese.login.service.EseLoginService;
import co.kr.fourteen.ese.login.vo.EseLoginVo;
import co.kr.fourteen.ese.user.service.EseUserService;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping(value="/ese/login/")
public class EseLoginController {


	@Autowired
	private EseLoginService eseLoginService;

	@Autowired
	private EseUserService eseUserService;

	/**
	* @Method loginPage
	* @Date 2024. 05. 26.
	* @Writter ese(어성은 )
	* @EditHistory
	* @Discript Seongeun Login Page.
	* @Return String
	*/
	@RequestMapping(value="loginPage", method = RequestMethod.GET) // 주소호출
	public String loginPage() {
		log.info(">>>>>eseLogin진입");
		return "ese/login/loginPage";
	}

	/**
	* @Method login
	* @Date 2024. 05. 28.
	* @Writter ese(어성은 )
	* @EditHistory
	* @Discript Seongeun Login 처리.
	 * @param EseLoginVo, HttpServletRequest, RedirectAttributes
	* @Return String
	*/
	@RequestMapping(value="login", method = RequestMethod.POST)
	public ModelAndView login(EseLoginVo loginVo, HttpServletRequest request, RedirectAttributes rttr){
		log.info("Controller loginPOST");
		ModelAndView mv = new ModelAndView("JSON_VIEW");

		// 로그인한 IP 주소 값 로그 찍기
		String ip = IpUtil.getClientIP(request);
		log.info(">>>>>>>>>>>> IP :: " + ip);

		String loginId  = (request.getParameter("userId") != null) ? request.getParameter("userId") : "";
		String password = (request.getParameter("userPw") != null) ? request.getParameter("userPw") : "";

		try {
			EseLoginVo checkLoginVo = new EseLoginVo();
			checkLoginVo = eseLoginService.userLogin(loginVo);
			if(!BCrypt.checkpw(password, checkLoginVo.getUserPw())) {
				mv.addObject("result", true);

				// 로그인 성공 시 세션에 사용자 정보 저장
				HttpSession session = request.getSession();
				session.setAttribute("loginId", loginId);
				session.setAttribute("userInfo", checkLoginVo);  // 필요한 정보를 저장
			} else {
				mv.addObject("result", false);
			}

		} catch (Exception e) {
			mv.addObject("result", false);
		}
		return mv;
	}

	/**
	* @Method logout
	* @Date 2024. 05. 28.
	* @Writter ese(어성은 )
	* @EditHistory
	* @Discript Seongeun logout 처리.
	 * @param HttpServletRequest
	* @Return String
	*/
	@RequestMapping(value="logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:ese/main";
	}

	/**
	 * @Method googleOtpPop
	 * @Date 2024. 06. 4.
	 * @Writter ese(어성은 )
	 * @EditHistory
	 * @Discript Seongeun googleOtpPop
	 * @Return ModelAndView
	 */
	@RequestMapping(value="googleOtpPop", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView googleOtpPop(HttpServletRequest req) {
		Rsa rsa = new Rsa();
		rsa.initRsa(req, "otp");
		ModelAndView mv = new ModelAndView("ese/otp/googleOtpPop");
		return mv;
	}

	/**
	 * @Method otpCreate
	 * @Date 2024. 06. 18.
	 * @Writter 어성은
	 * @Param String
	 * @Param String
	 * @Param String
	 * @Param HttpServletRequest
	 * @EditHistory
	 * @Discript otp QR바코드 생성 등록.
	 * @Return ModelAndView
	 */
	@RequestMapping(value="otpCreate", method=RequestMethod.GET)
	public ModelAndView otpCreate(@RequestParam String otpEmail, @RequestParam String userId, @RequestParam String userPw, HttpServletRequest req) throws Exception {
		 // 파라미터가 null인지 확인
		if (otpEmail == null || userId == null || userPw == null) {
			log.error("Required parameters are missing: otpEmail={}, userId={}, userPw={}", otpEmail, userId, userPw);
			throw new IllegalArgumentException("Required parameters are missing");
		}


		HttpSession session = req.getSession();
		Rsa rsa = new Rsa();
		PrivateKey privateKey = (PrivateKey) session.getAttribute(Rsa.RSA_OTP_KEY);


		if (privateKey == null) {
			throw new Exception("PrivateKey not found in session");
		}

		// 추가 로그
		log.info("otpEmail: {}", otpEmail);
		log.info("userId: {}", userId);
		log.info("userPw: {}", userPw);
		log.info("PrivateKey: " + privateKey);

		try {
			userPw = rsa.decryptRsa(privateKey, userPw);
		} catch (Exception e) {
			log.error("RSA Decryption error", e);
			throw new Exception("Decryption failed", e);
		}



		ModelAndView mv = new ModelAndView("JSON_VIEW");
		EseLoginVo loginVo = new EseLoginVo();
		GoogleOtp otp = new GoogleOtp();

		loginVo.setUserId(userId);
		loginVo = eseLoginService.selectUserLoginCheck(loginVo);

		if(loginVo == null) {
			mv.addObject(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.CM0010);
			mv.addObject(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.CM0010_MSG);
			return mv;
		}
		if(!BCrypt.checkpw(userPw, loginVo.getUserPw())) {
			mv.addObject(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.CM0006);
			mv.addObject(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.CM0006_MSG);
			return mv;
		}

		int idx = otpEmail.indexOf("@");
		String userName = otpEmail.substring(0, idx);
		String hostName = otpEmail.substring(idx + 1);

		HashMap<String, String> map = otp.generate(userName, hostName);
		String otpKey = map.get("encodedKey");
		String otpUrl = map.get("url");

		log.info(">>>>>>>>>>> : " + otpKey);
		log.info(">>>>>>>>>>> : " + otpUrl);

		try {
			loginVo.setOtpKey(otpKey);
			loginVo.setOtpUrl(otpUrl);
			loginVo.setUserEmail(otpEmail);
			eseLoginService.otpMerge(loginVo);
		} catch(Exception e) {
			mv.addObject(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.CM9999);
			mv.addObject(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.CM9999_MSG);
			return mv;
		}

		mv.addObject("qrCode", otpUrl);
		mv.addObject("otpKey", otpKey);
		mv.addObject(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.CM0000);

		return mv;
	}

	/**
	 * @Method otpCodeCheck
	 * @Date 2024. 06. 18.
	 * @Writter 어성은
	 * @Param String
	 * @Param String
	 * @Param Model
	 * @EditHistory
	 * @Discript otp 인증.
	 * @Return String
	 */
	@RequestMapping(value="otpcodeCheck", method=RequestMethod.GET)
	public String otpCodeCheck(@RequestParam String otpCode, @RequestParam String userId, Model model) {
		Map<String, Object> map = eseLoginService.otpCodeCheck(otpCode, userId);
		model.addAttribute(FrontBackErrorCode.RESULT_CD, map.get("resultCode"));
		model.addAttribute(FrontBackErrorCode.RESULT_MSG, map.get("resultMsg"));
		return "JSON_VIEW";
	}

	/**
	 * @Method findIdForm
	 * @Date 2024. 06. 10.
	 * @Writter ese(어성은 )
	 * @EditHistory
	 * @Discript 아이디 찾기 페이지
	 * @Return String
	 */
	@RequestMapping(value="findIdForm", method = RequestMethod.GET) // 주소호출
	public String findIdForm() {
		log.info(">>>>>findIdForm진입");
		return "ese/login/findIdForm";
	}

	/**
	 * @Method findId
	 * @Date 2024. 06. 10.
	 * @Writter ese(어성은 )
	 * @EditHistory
	 * @Discript 아이디 찾기
	 * @param HttpServletResponse, String, Model
	 * @Return String
	 */
	@RequestMapping(value = "findId", method = RequestMethod.POST)
	public String findId(HttpServletResponse response, @RequestParam("userPhone") String userPhone, Model md) throws Exception{
		md.addAttribute("userId", eseLoginService.findId(response, userPhone));
		return "ese/login/findId";
	}

	/**
	 * @Method resetPasswordPage
	 * @Date 2024. 06. 10.
	 * @Writter ese(어성은 )
	 * @EditHistory
	 * @Discript 비밀번호 초기화 페이지
	 * @Return String
	 */
	@RequestMapping(value="resetPasswordPage", method = RequestMethod.GET) // 주소호출
	public String resetPasswordPage() {
		log.info(">>>>>resetPasswordPage진입");
		return "ese/login/resetPasswordPage";
	}

	/**
	 * @Method resetPassword
	 * @Date 2024. 06. 10.
	 * @Writter ese(어성은 )
	 * @EditHistory
	 * @Discript 비밀번호 초기화
	 * @param String, Model
	 * @Return String
	 */
	@RequestMapping(value = "resetPassword", method = RequestMethod.POST)
	public String resetPassword(@RequestParam("userId") String userId, Model model) {
		try {
			eseLoginService.resetPassword(userId);
			model.addAttribute("message", "임시 비밀번호가 이메일로 전송되었습니다.");
		} catch (Exception e) {
			model.addAttribute("message", "비밀번호 초기화 중 오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace(); // 오류 로그를 콘솔에 출력
		}
		return "ese/login/resetPasswordResult";
	}



}
