package co.kr.fourteen.kcm.login.service;

import java.util.Map;

import co.kr.fourteen.kcm.login.vo.KcmLoginVo;

public interface KcmLoginService {

	public KcmLoginVo loginCheckUser(KcmLoginVo vo);

	public String findUserId(String userNm, String userEmail, String userPhone);

	public boolean findUserPw(KcmLoginVo vo);

	public boolean changeUserPw(KcmLoginVo vo);
	
	public Map<String, Object> otpCodeCheck(String otpCode, String userId);

	public void updateFalPw(KcmLoginVo loginVo);

	public void updateLoginUserInfo(KcmLoginVo loginVo) throws Exception;

	public void otpMerge(KcmLoginVo loginVo) throws Exception;
}
