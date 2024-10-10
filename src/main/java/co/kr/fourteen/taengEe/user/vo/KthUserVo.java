package co.kr.fourteen.taengEe.user.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KthUserVo {

    private static final long serialVersionUID = 3337545320035130909L;

//    private Integer registNo;
//    private String userId;
//    private String userPw;
//    private String tmprPwNo; // 임시비밀번호
//    private String userNm;
//    private String userEmail;
//    private String userPhone;
//    private String userZipCode;
//    private String userFirstAddr; // 기본주소
//    private String userSecondAddr; // 상세주소
//    private String userLevel; // 권한수준
//    private String userDelYn;
//    private String userDelDe; // 삭제 날짜
//    private String regDe; // 사용자 등록일
//    private String pwChangeDt; // 비밀번호 변경일
//    private String pwFailCnt; // 비밀번호 입력 실패  횟수
//    private String lastContactFmtDt; // 사용자가 마지막으로 접속한 날짜 시간
//    private String enabled; // 계정 활성화 여부
//    private String ipAddr; // 사용자가 마지막으로 접속한 IP 주소
//    private String pwChgYn; // 비밀번호 변경 여부
//    private String idBlockYn; // 계정 잠금 여부
//    private String otpYn; // OTP 사용 여부

//    private String userId;
//    private String userPw;
//    private String userPwCheck;
//    private String userName;
//    private String userNumber;

    private String registNo;
    private String userId;
    private String userPw;
    private String tmprPwNo;
    private String userNm;
    private String userEmail;
    private String userDomain;
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
    private String enabled;
    private String ipAddr;
    private String pwChgYn;
    private String idBlockYn;
    private String otpYn;

}
