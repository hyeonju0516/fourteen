package co.kr.fourteen.jiyy.oracle.service;

import co.kr.fourteen.jiyy.oracle.vo.JyOracleVo;

public interface JyOracleService {

	public String selectUserInfo(String userId);

	public String selectUserID(String name);

	public int addInfo(JyOracleVo vo);
}
