package co.kr.fourteen.seHyun.oracle.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;

@OracleSqlMapperScan
public interface YshOracleMapper {

	public String selectUserInfo(String userId);

}
