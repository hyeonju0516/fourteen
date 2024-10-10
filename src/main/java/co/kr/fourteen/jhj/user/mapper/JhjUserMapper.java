package co.kr.fourteen.jhj.user.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.jhj.user.vo.JhjUserVo;

@OracleSqlMapperScan
public interface JhjUserMapper {
	public int doubleCheckId(String userId);
	public void insertJhjUserJoin(JhjUserVo vo);
}
