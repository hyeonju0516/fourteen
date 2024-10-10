package co.kr.fourteen.common.util;


/**
 * Front Back 오류 코드 및 메시지 정의
 * @author 20180227
 *
 */

public class FrontBackErrorCode {
	public static final String RESULT_CD = "resultCode";				public static final String RESULT_MSG = "resultMsg";
	public static final String RESULT_MESSAGE = "resultMessage";

	//================================ 공통 ===============================
	public static final String CM0000 = "CM0000";					public static final String CM0000_MSG = "성공";
	public static final String CM0001 = "CM0001";					public static final String CM0001_MSG = "처리중 오류가 발생하였습니다.\n다시 시도해 주세요.";
	public static final String CM0002 = "CM0002";					public static final String CM0002_MSG = "필수 값이 없습니다.";
	public static final String CM0003 = "CM0003";					public static final String CM0003_MSG = "인증이 필요 합니다.";
	public static final String CM0004 = "CM0004";					public static final String CM0004_MSG = "해당 기간이 아닙니다.";
	public static final String CM0005 = "CM0005";					public static final String CM0005_MSG = "이미 참여하셨습니다.";
	public static final String CM0006 = "CM0006";					public static final String CM0006_MSG = "비밀번호를 다시 확인해 주세요.";
	public static final String CM0007 = "CM0007";					public static final String CM0007_MSG = "대상자가 아닙니다.";
	public static final String CM0008 = "CM0008";					public static final String CM0008_MSG = "선착순 종료되었습니다.";
	public static final String CM0009 = "CM0009";					public static final String CM0009_MSG = "잘못된 서비스 코드 입니다.";
	public static final String CM0010 = "CM0010";					public static final String CM0010_MSG = "사용자 정보가 없습니다.";
	public static final String CM0011 = "CM0011";					public static final String CM0011_MSG = "문자인증 오류 입니다.";
	public static final String CM9999 = "CM9999";					public static final String CM9999_MSG = "시스템 에러 발생";

	//================================ 모듈 ===============================
	public static final String MD0001 = "MD0001";					public static final String MD0001_MSG = "조회된 authKey가 없습니다.";
	public static final String MD0002 = "MD0002";					public static final String MD0002_MSG = "조회된 API정보가 없습니다.";
	public static final String MD0003 = "MD0003";					public static final String MD0003_MSG = "등록정보에 문제가 있습니다.";
	public static final String MD0004 = "MD0004";					public static final String MD0004_MSG = "회원정보 조회중 에러가 발생하였습니다.";
	public static final String MD0005 = "MD0005";					public static final String MD0005_MSG = "방갑습니다. api호출입니다.";
	public static final String MD0006 = "MD0006";					public static final String MD0006_MSG = "등록된 OTP가 없습니다. OTP를 등록하세요";
	public static final String MD0007 = "MD0007";					public static final String MD0007_MSG = "OTP 인증번호를 다시 확인해주세요";
	public static final String MD0008 = "MD0008";					public static final String MD0008_MSG = "인증번호가 전송되었습니다.";
	public static final String MD0009 = "MD0009";					public static final String MD0009_MSG = "본인인증이 확인 되었습니다.";
	public static final String MD0010 = "MD0010";					public static final String MD0010_MSG = "인증코드가 일치하지 않습니다.";
	public static final String MD0011 = "MD0011";					public static final String MD0011_MSG = "인증코드에 대한 유효시간이 경과 되었습니다. 인증코드를 재 전송 하세요.";
	public static final String MD0012 = "MD0012";					public static final String MD0012_MSG = "인증코드가 만료되었습니다. 인증번호를 다시 요청하세요";
}