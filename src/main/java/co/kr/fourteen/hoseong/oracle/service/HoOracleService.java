package co.kr.fourteen.hoseong.oracle.service;

import java.util.List;
import co.kr.fourteen.hoseong.oracle.vo.HoOracleVo;

public interface HoOracleService {

	public List<HoOracleVo> selectUserInfoList();

	public HoOracleVo selectUserInfoToNo(int userNo);

	public List<String> selectCityList();

	public List<String> selectCountyList(String data);

	public List<String> selectDistrictList(String data);

	public int insertUserInfo(HoOracleVo vo);

	public int updateUserInfo(HoOracleVo vo);

	public int deleteUserInfo(int userNo);

	public int selectMaxUserNo();

	public int selectUserIdCount(HoOracleVo vo);
}
