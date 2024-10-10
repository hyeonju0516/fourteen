package co.kr.fourteen.seHyun.user.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.seHyun.user.vo.YshUserVo;

@OracleSqlMapperScan
public interface YshUserMapper {
    public int idDoubleCheck(String userId);

    public String findId(String userName);

    public void userJoin(YshUserVo vo);

    public YshUserVo userLogin(YshUserVo vo);
}
