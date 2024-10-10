package co.kr.fourteen.seHyun.practice.search.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class YshSearchVo implements Serializable {

    private static final long serialVersionUID = -2651807986740191329L;

    private int registNo;
    private String userId;
    private String userPw;
    private String tmprPwNo;
    private String userNm;
    private String userEmail;
    private String userPhone;
    private String userZipCode;
    private String userFirstAddr;
    private String userSecondAddr;
    private String userLevel;
    private String userDelYn;
    private String userDelDe;
    private String regDe;
    private String pwChangeDt;
    private int pwFailCnt;
    private String lastContactFmtDt;
    private String Enabled;
    private String ipAddr;
    private String pwChgYn;
    private String idBlockYn;
    private char optYn;
}
