package co.kr.fourteen.cyj.login.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CyjLoginVo implements Serializable {

	private static final long serialVersionUID = 3337545320035130909L;

	private String registNo;
	private String userId;
	private String userPw;
	private String userNm;
	private String userEmail;
	private String userDomail;
	private String userPhone;
	private String userLevel;
	private String userDelYn;
	private String userDelDe;
	private String pwChangeDt;
	private int pwFailCnt;
	private String otpNumber;
	private String useYn;
	private String pwChgYn;
	private String idBlockYn;
	private String idBlockReason;
	private String hiddenPw;
	private String otpYn;
	private String otpUrl;
	private String otpKey;
	private String inOutGbn;
	private String successYn;
	private String failType;
	private String ipAddr;
	private String lastContactFmtDt;
	private String modDe;

}
