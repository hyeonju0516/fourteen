package co.kr.fourteen.cyj.user.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.cyj.user.vo.CyjUserVo;

@OracleSqlMapperScan
public interface CyjUserMapper {

	public int doubleCheckId(String userId);

	public void userJoin(CyjUserVo userVo);

}
