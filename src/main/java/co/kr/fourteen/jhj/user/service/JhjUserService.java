package co.kr.fourteen.jhj.user.service;

import co.kr.fourteen.jhj.user.vo.JhjUserVo;

public interface JhjUserService {
	public boolean doubleCheckUser(String userId);
	public void insertJhjUserJoin(JhjUserVo vo);
}
