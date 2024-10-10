package co.kr.fourteen.hjh2.user.mapper;

import org.apache.ibatis.annotations.Param;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.hjh2.user.vo.Jhj2UserInfoVo;

@OracleSqlMapperScan
public interface Jhj2UserMapper {
	public int doubleCheckId(String userId);
	public int userJoin(Jhj2UserInfoVo vo);
	public Jhj2UserInfoVo userLogin(@Param("user_id") String id, @Param("user_pw") String pw);
}
