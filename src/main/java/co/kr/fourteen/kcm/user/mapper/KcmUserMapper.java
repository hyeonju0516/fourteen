package co.kr.fourteen.kcm.user.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.kcm.user.vo.KcmUserInfoVo;

@OracleSqlMapperScan
public interface KcmUserMapper {

	public int doubleCheckId(String userId);
	public int userJoin(KcmUserInfoVo vo);

}
