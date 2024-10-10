package co.kr.fourteen.hoseong.user.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.hoseong.user.vo.KhsUserVo;

@OracleSqlMapperScan
public interface KhsUserMapper {
    public int selectUserIdCheck(String userId);

    public String selectMaxRegistNo(KhsUserVo vo);

    public void insertUser(KhsUserVo vo);

}
