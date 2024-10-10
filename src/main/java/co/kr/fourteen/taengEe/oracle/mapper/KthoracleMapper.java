package co.kr.fourteen.taengEe.oracle.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.taengEe.oracle.dto.KthOracleDto;

@OracleSqlMapperScan
public interface KthoracleMapper {

	List<KthOracleDto> selectUserInfoList();

	public String selectUserInfo(String userId);

	public String insertUserInfo(KthOracleDto dto);

}
