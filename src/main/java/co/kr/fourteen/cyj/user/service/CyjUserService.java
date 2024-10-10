package co.kr.fourteen.cyj.user.service;

import javax.servlet.http.HttpServletRequest;

import co.kr.fourteen.cyj.user.vo.CyjUserVo;

public interface CyjUserService {

	public boolean doubleCheckId(String userId);

	public void userJoin(CyjUserVo userVo, HttpServletRequest req) throws Exception;

}
