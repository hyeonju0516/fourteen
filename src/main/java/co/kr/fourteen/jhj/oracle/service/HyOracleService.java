package co.kr.fourteen.jhj.oracle.service;

import co.kr.fourteen.jhj.oracle.vo.HyOracleVo;

public interface HyOracleService {
	public String selectUserInfo(String userId);
	public void insertUserInfo(HyOracleVo hyOracleVo);
}