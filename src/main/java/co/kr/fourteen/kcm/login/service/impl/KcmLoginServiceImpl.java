package co.kr.fourteen.kcm.login.service.impl;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.common.mail.service.MailService;
import co.kr.fourteen.common.util.FrontBackErrorCode;
import co.kr.fourteen.common.util.GoogleOtp;
import co.kr.fourteen.kcm.login.mapper.KcmLoginMapper;
import co.kr.fourteen.kcm.login.service.KcmLoginService;
import co.kr.fourteen.kcm.login.vo.KcmLoginVo;



@Service
public class KcmLoginServiceImpl implements KcmLoginService {

	@Autowired
	private KcmLoginMapper kcmLoginMapper;

	@Autowired
	private MailService mailService;

	private static String sendEmailId = "hazedensays@naver.com";

	@Override
	public KcmLoginVo loginCheckUser(KcmLoginVo vo) {
		return kcmLoginMapper.loginCheckUser(vo);
	}

	@Override
	public String findUserId(String userNm, String userEmail, String userPhone) {
		System.out.println("Service - findUserId called with: " + userNm + ", " + userEmail + ", " + userPhone);
		String userId = kcmLoginMapper.findUserId(userNm, userEmail, userPhone);
        System.out.println("Service - userId: " + userId);
        return userId;
	}

	@Override
	public boolean findUserPw(KcmLoginVo vo) {
		boolean result = false;
		int checkUser = kcmLoginMapper.findUserPw(vo);

		if (checkUser > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean changeUserPw(KcmLoginVo kcmLoginVo) {
		boolean result = false;

		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder tempKey = new StringBuilder();
		SecureRandom random = new SecureRandom();

		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(characters.length());
			tempKey.append(characters.charAt(index));
		}

		String tempPw = tempKey.toString();

		kcmLoginVo.setUserPw(BCrypt.hashpw(tempPw, BCrypt.gensalt()));

		String subject = "[임시 비밀번호 발급]" + kcmLoginVo.getUserNm() + "님의 \"임시 비밀번호\" 이메일 입니다.";
		StringBuilder sb = new StringBuilder();
		sb.append(kcmLoginVo.getUserNm() + "님의 임시 비밀번호는 ["+ tempPw + "] 입니다.");
		mailService.send(subject, sb.toString(), sendEmailId, kcmLoginVo.getUserEmail(), null);

		if(kcmLoginMapper.changeUserPw(kcmLoginVo) > 0) {
			result = true;
		}

		return result;
	}
	
	@Override
	public Map<String, Object> otpCodeCheck(String otpCode, String userId) {
		GoogleOtp otp = new GoogleOtp();
		Map<String, Object> map = new HashMap<String, Object>();
		String otpkey = kcmLoginMapper.selectOtpCodeCheck(userId);
		boolean result = false;
		if(otpkey == null) {
			map.put(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.MD0006);
			map.put(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.MD0006_MSG);
			return map;
		}

		result = otp.checkCode(otpkey, otpCode);

		if(!result) {
			map.put(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.MD0007);
			map.put(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.MD0007_MSG);
			return map;
		}

		map.put(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.CM0000);
		return map;
	}

	@Override
	public void updateFalPw(KcmLoginVo loginVo) {
		kcmLoginMapper.updateFalPw(loginVo);
	}

	@Override
	public void updateLoginUserInfo(KcmLoginVo loginVo) throws Exception {
		kcmLoginMapper.loginHist(loginVo);
		kcmLoginMapper.updateLoginUserInfo(loginVo);
	}

	@Override
	public void otpMerge(KcmLoginVo loginVo) throws Exception {
		kcmLoginMapper.updateUserOtpYn(loginVo);
		kcmLoginMapper.otpMerge(loginVo);
	}
}
