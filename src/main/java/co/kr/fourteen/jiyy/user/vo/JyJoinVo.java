package co.kr.fourteen.jiyy.user.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JyJoinVo {
	//받아오는 인풋의 id와 일치해야함.
	private String userId;
	private String userPw;
	private String userPwCheck;
	private String userNm;
	private String userEmail;
	private String userDomail;
	private String userPhone;
	private String userZipCode;
	private String userFirstAddr;
	private String userSecondAddr;
}
