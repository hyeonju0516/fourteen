package co.kr.fourteen.seHyun.practice.user.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;

@OracleSqlMapperScan
public interface YshPracticeUserMapper {

    public int idDoubleCheckBool(String userId);

    public String idDoubleCheckInt(String userId);
}
