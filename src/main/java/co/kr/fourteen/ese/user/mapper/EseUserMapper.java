package co.kr.fourteen.ese.user.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.ese.user.vo.EseUserVo;

import java.util.List;

@OracleSqlMapperScan
public interface EseUserMapper {

	// ID 중복확인
	public int doubleCheckId(String userId);

	// 회원가입
	public void insertInfo(EseUserVo info);

	public List<EseUserVo> userList();

	public EseUserVo findUserByIdAndPassword(EseUserVo userVo);
}



