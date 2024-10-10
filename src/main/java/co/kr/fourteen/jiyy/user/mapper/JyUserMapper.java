package co.kr.fourteen.jiyy.user.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.jiyy.user.vo.JyUserVo;

@OracleSqlMapperScan
public interface JyUserMapper {

	public boolean userIdCheck(String userId);

	public List<JyUserVo> userJoinData(JyUserVo userData);

	public JyUserVo userLoginCheck(JyUserVo userLoginDt);
}
