package co.kr.fourteen.kcm.login.controller;

import java.security.PrivateKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kr.fourteen.common.mail.service.MailService;
import co.kr.fourteen.common.util.CertificationKeyGenerator;
import co.kr.fourteen.common.util.FrontBackErrorCode;
import co.kr.fourteen.common.util.GoogleOtp;
import co.kr.fourteen.common.util.IpUtil;
import co.kr.fourteen.common.util.Rsa;
import co.kr.fourteen.common.util.mapper.CertifiMapper;
import co.kr.fourteen.kcm.login.service.KcmLoginService;
import co.kr.fourteen.kcm.login.vo.KcmLoginVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/kcm/login/")
public class KcmLoginController {

	@Autowired
	private MailService mailService;

	private static String sendEmailId = "hazedensays@naver.com";

	@Autowired
	private KcmLoginService kcmLoginService;

	@Autowired
	private CertifiMapper certifiMapper;

	/**
	 * @Method kcmLogin
	 * @Date 2024. 06. 06
	 * @Writter KCM
	 * @Param HttpServletRequest
	 * @EditHistory
	 * @Discript 로그인페이지 진입
	 * @Return String
	 */
	@RequestMapping(value="loginPage", method = {RequestMethod.GET, RequestMethod.POST})
	public String kcmLogin(HttpServletRequest req) {
		Rsa rsa = new Rsa();
		rsa.initRsa(req, "web");
		return "kcm/login/login";
	}

	/**
	 * @Method loginPost
	 * @Date 2024. 06. 06
	 * @Writter KCM
	 * @Param KcmLoginVo
	 * @Param HttpServletRequest
	 * @EditHistory
	 * @Discript 로그인
	 * @Return ModelAndView
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="login", method = RequestMethod.POST)
	public ModelAndView loginPost(KcmLoginVo vo, HttpServletRequest req) throws Exception {
		//login페이지에 접속한 ip 추출
		//String ip = IpUtil.getClientIP(req);
		log.info("login vo ==> " + vo);

		String loginId  = (req.getParameter("userId") != null) ? req.getParameter("userId") : "";
		String loginPw = (req.getParameter("userPw") != null) ? req.getParameter("userPw") : "";

		log.info("userId >>> " + vo.getUserId());
		log.info("userPw >>> " + vo.getUserPw());

		HttpSession session = req.getSession();

		Rsa rsa = new Rsa();
		PrivateKey privateKey = (PrivateKey)session.getAttribute(Rsa.RSA_WEB_KEY);
		String password = rsa.decryptRsa(privateKey, vo.getUserPw());

		log.info("복호화한 userPw >>> " + password);

		String redirectUrl = "redirect:/kcmMain";
		String falUrl = "redirect:/kcm/login/loginPage?LOGIN_ERR=";
		String ip = IpUtil.getClientIP(req);

		KcmLoginVo checkLoginVo = new KcmLoginVo();
		checkLoginVo = kcmLoginService.loginCheckUser(vo);

		if(checkLoginVo == null) {
			redirectUrl = falUrl + "IDNE";
		} else if("Y".equals(checkLoginVo.getIdBlockYn())) {
			redirectUrl = falUrl + "IDBL";
		} else if(checkLoginVo.getPwFailCnt() == 5) {
			redirectUrl = falUrl + "PWNE5";
		} else if(!BCrypt.checkpw(password, checkLoginVo.getUserPw())) {
			kcmLoginService.updateFalPw(vo);
			redirectUrl = falUrl + "PWNE";
		} else {
			session.setAttribute("lastContactFmtDt", checkLoginVo.getLastContactFmtDt());
			session.setAttribute("userNm", checkLoginVo.getUserNm());
			session.setAttribute("ipAddr", ip);
			session.setAttribute("SESSION_ID", "fourteen");
			kcmLoginService.updateLoginUserInfo(vo);
		}

		ModelAndView mv = new ModelAndView(redirectUrl);
		return mv;
	}

	/**
	 * @Method googleOtpPop
	 * @Date 2024. 06. 06
	 * @Writter KCM
	 * @Param HttpServletRequest
	 * @EditHistory
	 * @Discript opt 진입
	 * @Return String
	 */
	@RequestMapping(value="googleOtpPop", method={RequestMethod.GET, RequestMethod.POST})
	public String googleOtpPop(HttpServletRequest req) {
		Rsa rsa = new Rsa();
		rsa.initRsa(req, "otp");
		return "kcm/otp/googleOtpPop";
	}

	/**
	 * @Method otpCreate
	 * @Date 2024. 06. 08
	 * @Writter KCM
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
		HttpSession session = req.getSession();
		Rsa rsa = new Rsa();
		PrivateKey privateKey = (PrivateKey) session.getAttribute(Rsa.RSA_OTP_KEY);
		userPw = rsa.decryptRsa(privateKey, userPw);
		ModelAndView mv = new ModelAndView("JSON_VIEW");
		KcmLoginVo loginVo = new KcmLoginVo();
		GoogleOtp otp = new GoogleOtp();

		loginVo.setUserId(userId);
		loginVo = kcmLoginService.loginCheckUser(loginVo);

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
			kcmLoginService.otpMerge(loginVo);
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
	 * @Date 2024. 06. 25
	 * @Writter KCM
	 * @Param String
	 * @Param String
	 * @Param Model
	 * @EditHistory
	 * @Discript otp 인증.
	 * @Return String
	 */
	@RequestMapping(value="otpCodeCheck", method=RequestMethod.GET)
	public String otpCodeCheck(@RequestParam String otpCode, @RequestParam String userId, Model model) {
		Map<String, Object> map = kcmLoginService.otpCodeCheck(otpCode, userId);
		model.addAttribute(FrontBackErrorCode.RESULT_CD, map.get("resultCode"));
		model.addAttribute(FrontBackErrorCode.RESULT_MSG, map.get("resultMsg"));
		return "JSON_VIEW";
	}

	/**
	 * @Method phoneSend
	 * @Date 2024.06.25
	 * @Writter KCM
	 * @Param String
	 * @Param Model
	 * @Param HttpSession
	 * @EditHistory
	 * @Discript 인증키 전송.
	 * @Return String
	 */
	@RequestMapping(value="send/phoneSend", method=RequestMethod.POST)
	public String phoneSend(@RequestParam("phoneNumber") String phoneNumber, Model model, HttpSession session) throws Exception {

		log.info("전화번호에 대한 인증키 생성을 시행합니다.");
		log.info("전화번호 :: " + phoneNumber);

		try{
			//인증키 삭제 & 생성 루틴 실행
			CertificationKeyGenerator.newInstance().tempKeyGenerator(certifiMapper, phoneNumber, session);

			model.addAttribute(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.MD0008);
			model.addAttribute(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.MD0008_MSG);
		} catch(Exception e) {
			model.addAttribute(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.CM0011);
			model.addAttribute(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.CM0011_MSG);
		}
		return "JSON_VIEW";
	}

	/**
	 * @Method certificationCodeCheck
	 * @Date 2024.06.25
	 * @Writter KCM
	 * @Param String
	 * @Param String
	 * @Param Model
	 * @Param HttpSession
	 * @EditHistory
	 * @Discript 인증키 체크
	 * @Return String
	 */
	@RequestMapping(value="send/certificationCodeCheck", method=RequestMethod.POST)
	public String phoneSend(@RequestParam("certificationCode") String certificationCode, @RequestParam("phoneNumber") String phoneNumber, Model model, HttpSession session) throws Exception {

		log.info("sms인증을위해 디비와 값매칭을 시도합니다.");
		log.info("certificationCode : " + certificationCode);
		log.info("phoneNumber : " + phoneNumber);

		String token = (String)session.getAttribute("token");

		try {
			if(token != null) {
				long tokenValidTime = ((Long) session.getAttribute("tokenValidTime")).longValue();
				long timestamp = (new Date()).getTime();

				log.info("유효시간확인 : " + timestamp + " : " + tokenValidTime);

				if(timestamp < tokenValidTime) {
					if(certificationCode.equals(token) && CertificationKeyGenerator.newInstance().isCorrectCertifiKey(certifiMapper, phoneNumber, certificationCode)) {
						model.addAttribute(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.MD0009);
						model.addAttribute(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.MD0009_MSG);
					} else {
						model.addAttribute(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.MD0010);
						model.addAttribute(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.MD0010_MSG);
					}
				} else {
					model.addAttribute(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.MD0011);
					model.addAttribute(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.MD0011_MSG);
				}
			} else {
				model.addAttribute(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.MD0012);
				model.addAttribute(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.MD0012_MSG);
			}
		} catch(Exception e) {
			model.addAttribute(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.CM0001);
			model.addAttribute(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.CM9999_MSG);
		}
		return "JSON_VIEW";
	}

	/**
	 * @Method findUserIdPop
	 * @Date 2024. 06. 08
	 * @Writter KCM
	 * @EditHistory
	 * @Discript 아이디 찾기 진입
	 * @Return String
	 */
	@RequestMapping(value="findUserId", method = RequestMethod.GET) // 주소호출
	public String findUserIdPage() {
		return "kcm/login/findUserId";
	}

	/**
	 * @Method findUserId
	 * @Date 2024. 06. 08
	 * @Writter KCM
	 * @Param String
	 * @EditHistory
	 * @Discript ID 찾기
	 * @Return ModelAndView
	 */
	@RequestMapping(value="/findUserId", method=RequestMethod.POST)
	public ModelAndView findUserId(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("JSON_VIEW");

		System.out.println("controller 접근 &&&&&&&");
		String findUserName = (req.getParameter("userNm") != null) ? req.getParameter("userNm") : "";
		String findUserEmail = (req.getParameter("userEmail") != null) ? req.getParameter("userEmail") : "";
		String findUserPhone = (req.getParameter("userPhone") != null) ? req.getParameter("userPhone") : "";

		System.out.println("Parameters: " + findUserName + ", " + findUserEmail + ", " + findUserPhone);

		try {
			if (!findUserEmail.isEmpty() && !findUserPhone.isEmpty() && !findUserName.isEmpty()) {

				String userId = kcmLoginService.findUserId(findUserName, findUserEmail, findUserPhone);
				System.out.println("userId ====> " + userId);

				String subject = "[아이디 찾기]" + findUserName + "님의 \"아이디 찾기\" 이메일 입니다.";
				StringBuilder sb = new StringBuilder();
				sb.append(findUserName + "님의 아이디는 ["+ userId + "] 입니다.");
				mailService.send(subject, sb.toString(), sendEmailId, findUserEmail, null);

				mv.addObject("result", true);
			} else {
				mv.addObject("result", false);
			}
		} catch (Exception e) {
			mv.addObject("result", false);
		}

		return mv;
	}


	/**
	 * @Method findUserIdPop
	 * @Date 2024. 06. 08
	 * @Writter KCM
	 * @EditHistory
	 * @Discript 아이디 찾기 진입
	 * @Return String
	 */
	@RequestMapping(value="findUserPw", method = RequestMethod.GET) // 주소호출
	public String changeUserPwPage() {
		return "kcm/login/findUserPw";
	}

	/**
	 * @Method changeUserPw
	 * @Date 2024. 06. 12
	 * @Writter KCM
	 * @Param String
	 * @EditHistory
	 * @Discript PW 변경
	 * @Return ModelAndView
	 */
	@RequestMapping(value="/findUserPw", method=RequestMethod.POST)
	public ModelAndView changeUserPw(KcmLoginVo vo) {
		ModelAndView mv = new ModelAndView("JSON_VIEW");
		boolean result = false;

		if (kcmLoginService.findUserPw(vo)) {
			if (kcmLoginService.changeUserPw(vo)) {
				result = true;
			}
		}
		mv.addObject("result", true);

		return mv;
	}

}
