package co.kr.fourteen.seHyun.oracle.service.impl;

import org.springframework.stereotype.Service;

import co.kr.fourteen.seHyun.oracle.mapper.YshOracleMapper;
import co.kr.fourteen.seHyun.oracle.service.YshOracleService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class YshOracleServiceImpl implements YshOracleService{

	private final YshOracleMapper yshOracleMapper;

	@Override
	public String selectUserInfo(String userId) {
		return "".equals(userId) ? "" : yshOracleMapper.selectUserInfo(userId);
	}
}
