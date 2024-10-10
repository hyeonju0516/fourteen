package co.kr.fourteen.jhj.login.service;

import java.util.Map;

import co.kr.fourteen.jhj.user.vo.JhjUserVo;

public interface JhjLoginService {
	public JhjUserVo selectJhjUserPw(JhjUserVo vo);
	public Map<String, String> resetPw(JhjUserVo vo);
	public Map<String, String> findId(JhjUserVo vo);
}
