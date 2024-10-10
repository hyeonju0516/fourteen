package co.kr.fourteen.hoseong.login.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.hoseong.user.vo.KhsUserVo;

@OracleSqlMapperScan
public interface KhsLoginMapper {

    public KhsUserVo selectLoginCheck(KhsUserVo vo);

}
