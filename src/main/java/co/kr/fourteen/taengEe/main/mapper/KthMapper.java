package co.kr.fourteen.taengEe.main.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.taengEe.main.vo.KthVo;

@OracleSqlMapperScan
public interface KthMapper {


	public List<KthVo> selectUserInfoList();

	public String insertUserInfo(KthVo vo);

}
