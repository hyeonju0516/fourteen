package co.kr.fourteen.hoseong.oracle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.log.Log;

import co.kr.fourteen.hoseong.oracle.mapper.HoOracleMapper;
import co.kr.fourteen.hoseong.oracle.service.HoOracleService;
import co.kr.fourteen.hoseong.oracle.vo.HoOracleVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HoOracleServiceImpl implements HoOracleService{

	@Autowired
	private HoOracleMapper hoOracleMapper;

	@Override
	public List<HoOracleVo> selectUserInfoList() {
		return hoOracleMapper.selectUserInfoList();
	}

	@Override
	public HoOracleVo selectUserInfoToNo(int userNo) {
		return hoOracleMapper.selectUserInfoToNo(userNo);
	}

	@Override
	public int insertUserInfo(HoOracleVo vo) {

		int isTrue = 0;

		// 이곳에 validation 넣을까 말까...
		if(true) {
			hoOracleMapper.insertUserInfo(vo);
			isTrue = 1;
		}

		return isTrue;
	}

	@Override
	public int updateUserInfo(HoOracleVo vo) {

		int isTrue = 0;

		if(true) {
			hoOracleMapper.updateUserInfo(vo);
			isTrue = 1;
		}

		return isTrue;
	}

	@Override
	public int deleteUserInfo(int userNo) {
		int isTrue = 0;

		if(true) {
			hoOracleMapper.deleteUserInfo(userNo);
			isTrue = 1;
		}
		return isTrue;
	}

	@Override
	public int selectMaxUserNo() {
		return hoOracleMapper.selectMaxUserNo();
	}

	@Override
	public int selectUserIdCount(HoOracleVo vo) {
		return hoOracleMapper.selectUserIdCount(vo);
	}

	@Override
	public List<String> selectCityList() {
		return hoOracleMapper.selectCityList();
	}

	@Override
	public List<String> selectCountyList(String data) {
		return hoOracleMapper.selectCountyList(data);
	}

	@Override
	public List<String> selectDistrictList(String data) {
		return hoOracleMapper.selectDistrictList(data);
	}

}
