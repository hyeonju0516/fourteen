package co.kr.fourteen.ese.login.service;


import co.kr.fourteen.ese.login.vo.EseLoginVo;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public interface EseLoginService {

	// 로그인
	public EseLoginVo userLogin(EseLoginVo loginVo);

	// 아이디 찾기
	public String findId(HttpServletResponse response, String userId) throws Exception;

	// 비밀번호 초기화
	public void resetPassword(String userId) throws Exception;

	public Map<String, Object> otpCodeCheck(String otpCode, String userId);

	public EseLoginVo selectUserLoginCheck(EseLoginVo loginVo);

	public void otpMerge(EseLoginVo loginVo) throws Exception;

}
