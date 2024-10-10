package co.kr.fourteen.taengEe.login.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KthLoginVo {

    private static final long serialVersionUID = 3337545320035130909L;

    private String userId;
    private String userPw;
    private String userNm;
    private String userEmail;
    private String userDomail;
    private String userPhone;
    private String otpNumber;
    private String otpYn;
    private String hiddenPw;
    private String otpUrl;
    private String otpKey;

}
