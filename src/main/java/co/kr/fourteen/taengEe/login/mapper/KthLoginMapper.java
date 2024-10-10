package co.kr.fourteen.taengEe.login.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.taengEe.login.vo.KthLoginVo;

@OracleSqlMapperScan
public interface KthLoginMapper {
    public KthLoginVo loginCheck(KthLoginVo vo);
}
