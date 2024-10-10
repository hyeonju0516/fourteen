package co.kr.fourteen.taengEe.oracle.service;

import java.util.List;

import co.kr.fourteen.taengEe.oracle.dto.KthOracleDto;

public interface KthoracleService {

	public String selectUserInfo(String userId);

	public String insertUserInfo(KthOracleDto dto);

	List<KthOracleDto> selectUserInfoList();

}
