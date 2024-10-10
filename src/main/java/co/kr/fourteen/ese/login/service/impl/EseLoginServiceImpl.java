package co.kr.fourteen.ese.login.service.impl;

import co.kr.fourteen.common.mail.service.MailService;
import co.kr.fourteen.common.util.FrontBackErrorCode;
import co.kr.fourteen.common.util.GoogleOtp;
import co.kr.fourteen.ese.login.mapper.EseLoginMapper;
import co.kr.fourteen.ese.login.service.EseLoginService;
import co.kr.fourteen.ese.login.vo.EseLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

// TODO 스페이스 공백
@Service
public class EseLoginServiceImpl implements EseLoginService {

	@Autowired
	private EseLoginMapper eseLoginMapper;

	@Autowired
    private MailService mailService;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private static final String sendEmailId = "remember9659@gmail.com";


	// 로그인
	@Override
	public EseLoginVo userLogin(EseLoginVo loginVo) {
		return eseLoginMapper.login(loginVo);
	}

	// 아이디 찾기
	@Override
	public String findId(HttpServletResponse response, String userPhone) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = eseLoginMapper.findId(userPhone);

		if(id == null) {
			out.println("<script>alert('가입된 아이디가 없습니다.');history.go(-1);</script>");
			out.close();
			return null;

		} else {
			return id;
		}

	}

	// 비밀번호 초기화
	@Override
	public void resetPassword(String userId) throws Exception {
		// 아이디로 이메일 조회
		String email = eseLoginMapper.findEmailByUserId(userId);
		if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
			throw new Exception("유효하지 않은 이메일 주소입니다: " + email);
		}

		// 임시 비밀번호 생성
		String tempPassword = generateTempPassword();

		// 임시 비밀번호로 업데이트
		eseLoginMapper.updatePassword(userId, tempPassword);

		// 사용자에게 이메일로 임시 비밀번호 전송
		sendTempPasswordEmail(email, tempPassword);
	}

	// 임시 비밀번호 생성
	private String generateTempPassword() {
		// 임시 비밀번호 생성 로직 (예: 랜덤 문자열 생성)
		return UUID.randomUUID().toString().substring(0, 8);
	}

	// 임시 비밀번호 메일 안내
	private void sendTempPasswordEmail(String email, String tempPassword) throws Exception {
		String subject = "비밀번호 초기화 안내";
		String text = "임시 비밀번호는 " + tempPassword + " 입니다. 로그인 후 비밀번호를 변경해 주세요.";
		boolean emailSent = mailService.send(subject, text, sendEmailId, email, null);
		if (!emailSent) {
			throw new Exception("이메일 전송 중 오류가 발생했습니다.");
		}
	}

	@Override
	public Map<String, Object> otpCodeCheck(String otpCode, String userId) {
		GoogleOtp otp = new GoogleOtp();
		Map<String, Object> map = new HashMap<String, Object>();
		String otpkey = eseLoginMapper.selectOtpCodeCheck(userId);
		boolean result = false;
		if(otpkey == null) {
			map.put(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.MD0007);
			map.put(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.MD0007_MSG);
			return map;
		}

		map.put(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.CM0000);
		return map;
	}

	@Override
	public EseLoginVo selectUserLoginCheck(EseLoginVo loginVo) {
		return eseLoginMapper.selectUserLoginCheck(loginVo);
	}

	@Override
	public void otpMerge(EseLoginVo loginVo) throws Exception {
		eseLoginMapper.updateUserOtpYn(loginVo);
		eseLoginMapper.otpMerge(loginVo);
	}
}
