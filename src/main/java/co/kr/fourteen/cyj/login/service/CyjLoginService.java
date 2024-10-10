package co.kr.fourteen.cyj.login.service;

import java.util.Map;

import co.kr.fourteen.cyj.login.vo.CyjLoginVo;

public interface CyjLoginService {

	public CyjLoginVo selectUserLoginCheck(CyjLoginVo loginVo);

	public Map<String, Object> otpCodeCheck(String otpCode, String userId);

	public void updateFalPw(CyjLoginVo loginVo);

	public void updateLoginUserInfo(CyjLoginVo loginVo) throws Exception;

	public void otpMerge(CyjLoginVo loginVo) throws Exception;

}
