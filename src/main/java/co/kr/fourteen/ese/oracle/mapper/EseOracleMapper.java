package co.kr.fourteen.ese.oracle.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;

@OracleSqlMapperScan
public interface EseOracleMapper {

	public String selectUserInfo(String useId);

}
