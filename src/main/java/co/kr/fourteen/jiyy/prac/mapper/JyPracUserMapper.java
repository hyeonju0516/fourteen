package co.kr.fourteen.jiyy.prac.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;

@OracleSqlMapperScan
public interface JyPracUserMapper {
	public int userIdCheck(String userId);
}
