package co.kr.fourteen.jiyy.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.jiyy.oracle.mapper.JyOracleMapper;
import co.kr.fourteen.jiyy.oracle.service.JyOracleService;
import co.kr.fourteen.jiyy.oracle.vo.JyOracleVo;

@Service
public class JyOracleServiceImpl implements JyOracleService {

	@Autowired
	private JyOracleMapper jyOracleMapper;

	@Override
	public String selectUserInfo(String userId) {
		return "".equals(userId) ? "" : jyOracleMapper.selectUserInfo(userId);
	}

	@Override
	public String selectUserID(String name) {
		return "".equals(name) ? "삐삒" : jyOracleMapper.selectUserID(name);
	}

	@Override
	public int addInfo(JyOracleVo vo) {
		return jyOracleMapper.addInfo(vo);
	}
}
