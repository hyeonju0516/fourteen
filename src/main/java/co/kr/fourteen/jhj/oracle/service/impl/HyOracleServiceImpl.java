package co.kr.fourteen.jhj.oracle.service.impl;

import org.springframework.stereotype.Service;
import co.kr.fourteen.jhj.oracle.mapper.HyOracleMapper;
import co.kr.fourteen.jhj.oracle.service.HyOracleService;
import co.kr.fourteen.jhj.oracle.vo.HyOracleVo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HyOracleServiceImpl implements HyOracleService{

	private final HyOracleMapper hyOracleMapper = null;

	@Override
	public String selectUserInfo(String userId) {
		log.info(">>> 서비스 진입");
		return "".equals(userId) ? "" : hyOracleMapper.selectUserInfo(userId);
	}

	@Override
	public void insertUserInfo(HyOracleVo hyOracleVo) {
		log.info(">>> insertUserInfo 진입");
		hyOracleMapper.insertUserInfo(hyOracleVo);
	}
}
