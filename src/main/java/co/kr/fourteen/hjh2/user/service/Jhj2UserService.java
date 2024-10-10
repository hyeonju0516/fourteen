package co.kr.fourteen.hjh2.user.service;

import co.kr.fourteen.hjh2.user.vo.Jhj2UserInfoVo;

public interface Jhj2UserService {
	public boolean doubleCheckId(String userId);
	public boolean userJoin(Jhj2UserInfoVo vo);
	public Jhj2UserInfoVo userLogin(String id, String pw);
}
