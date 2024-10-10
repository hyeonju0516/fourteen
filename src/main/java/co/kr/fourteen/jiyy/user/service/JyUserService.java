package co.kr.fourteen.jiyy.user.service;

import java.util.List;

import co.kr.fourteen.jiyy.user.vo.JyUserVo;

public interface JyUserService {
	public boolean userIdCheck(String userId);

	public List<JyUserVo> userJoinData(JyUserVo userData);

	public JyUserVo userLoginCheck(JyUserVo userLoginDt);
}
