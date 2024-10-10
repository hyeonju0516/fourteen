package co.kr.fourteen.ese.login.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class EseLoginVo implements Serializable {

	private static final long serialVersionUID = 3337545320035130909L;

	private Integer registNo;						// 고유번호
	private String userId;							// 아이디
	private String userPw;							// 비밀번호
	private String tmprPwNo; 						// 임시비밀번호
	private String userNm;							// 이름
	private String userEmail;						// 이메일
	private String userPhone;						// 핸드폰번호
	private String userZipCode;						// 우편번호
	private String userFirstAddr; 					// 기본주소
	private String userSecondAddr; 					// 상세주소
	private String userLevel; 						// 권한수준
	private String userDelYn;						// 탈퇴 여부
	private String userDelDe; 						// 탙퇴 날짜
	private String regDe; 							// 사용자 등록일
	private String pwChangeDt; 						// 비밀번호 변경일
	private String pwFailCnt; 						// 비밀번호 입력 실패  횟수
	private String lastContactFmtDt; 				// 사용자가 마지막으로 접속한 날짜 시간
	private String enabled; 						// 계정 활성화 여부
	private String ipAddr; 							// 사용자가 마지막으로 접속한 IP 주소
	private String pwChgYn; 						// 비밀번호 변경 여부
	private String idBlockYn; 						// 계정 잠금 여부
	private String otpYn; 							// OTP 사용 여부
	private String otpUrl;
	private String otpKey;

}
