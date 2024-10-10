package co.kr.fourteen.jiyy.oracle.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.jiyy.oracle.vo.JyOracleVo;

@OracleSqlMapperScan
public interface JyOracleMapper {

	public String selectUserInfo(String userId);

	public String selectUserID(String name);

	public int addInfo(JyOracleVo vo);
}
