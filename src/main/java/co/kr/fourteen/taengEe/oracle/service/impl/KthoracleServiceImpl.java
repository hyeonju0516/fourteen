package co.kr.fourteen.taengEe.oracle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.taengEe.oracle.dto.KthOracleDto;
import co.kr.fourteen.taengEe.oracle.mapper.KthoracleMapper;
import co.kr.fourteen.taengEe.oracle.service.KthoracleService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KthoracleServiceImpl implements KthoracleService {

	@Autowired
	private KthoracleMapper kthoracleMapper;

	@Override
	public String selectUserInfo(String userId) {
		return "".equals(userId) ? "": kthoracleMapper.selectUserInfo(userId);
	}

	@Override
	public String insertUserInfo(KthOracleDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KthOracleDto> selectUserInfoList() {
		// TODO Auto-generated method stub
		return null;
	}

}
