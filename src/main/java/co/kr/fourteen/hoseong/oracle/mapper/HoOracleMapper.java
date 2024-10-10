package co.kr.fourteen.hoseong.oracle.mapper;


import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.hoseong.oracle.vo.HoOracleVo;

@OracleSqlMapperScan
public interface HoOracleMapper {

	public List<HoOracleVo> selectUserInfoList();

	public HoOracleVo selectUserInfoToNo(int userNo);

	public List<String> selectCityList();

	public List<String> selectCountyList(String data);

	public List<String> selectDistrictList(String data);

	public void insertUserInfo(HoOracleVo vo);

	public int updateUserInfo(HoOracleVo vo);

	public int deleteUserInfo(int userNo);

	public int selectMaxUserNo();

	public int selectUserIdCount(HoOracleVo vo);

}
