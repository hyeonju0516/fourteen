package co.kr.fourteen.jhj.oracle.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.jhj.oracle.vo.HyOracleVo;

@OracleSqlMapperScan
public interface HyOracleMapper {
	public String selectUserInfo(String userId);
	public void insertUserInfo(HyOracleVo hyOracleVo);
}