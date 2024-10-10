package co.kr.fourteen.kcm.oracle.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;

//@Mapper
@OracleSqlMapperScan
public interface KcmoracleMapper {

	public String selectUserInfo(String useId);

}
