package co.kr.fourteen.chaesong.main.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;

@OracleSqlMapperScan
public interface YcsMainMapper {

	String selectUserInfo(String name);
}
