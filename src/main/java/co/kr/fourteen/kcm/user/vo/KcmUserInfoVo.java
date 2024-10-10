package co.kr.fourteen.kcm.user.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KcmUserInfoVo implements Serializable{

	private static final long serialVersionUID = 4694997288591128590L;

	private String registNo;
	private String userId;
	private String userPw;
	private String hiddenPw;
	private String tmprPwNo;
	private String userNm;
	private String userEmail;
	private String userDomail;
	private String userPhone;
	private String userZipCode;
	private String userFirstAddr;
	private String userSecondAddr;
	private String userLevel;
	private String userDelYn;
	private String userDelDe;
    private String regDe;
    private String pwChangeDt;
    private String pwFailCnt;
    private String lastContactFmtDt;
    private String useYn;
    private String ipAddr;
    private String pwChgYn;
    private String idBlockYn;
    private String idBlockReason;
    private String otpYn;
    private String modDe;
}
