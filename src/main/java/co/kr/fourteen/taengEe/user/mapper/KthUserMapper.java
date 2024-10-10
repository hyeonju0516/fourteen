package co.kr.fourteen.taengEe.user.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.taengEe.user.vo.KthUserVo;

@OracleSqlMapperScan
public interface KthUserMapper {
    public int doubleCheckId(String userId);

    int doubleCheckId2(String userId);

    int joinCheck(KthUserVo vo);
}
