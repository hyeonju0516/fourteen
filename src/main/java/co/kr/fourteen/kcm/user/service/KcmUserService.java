package co.kr.fourteen.kcm.user.service;

import javax.servlet.http.HttpServletRequest;

import co.kr.fourteen.kcm.user.vo.KcmUserInfoVo;

public interface KcmUserService {

	public boolean doubleCheckId(String userId);
	public boolean userJoin(KcmUserInfoVo vo,  HttpServletRequest req) throws Exception;

}
