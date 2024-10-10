package co.kr.fourteen.jhj.login.mapper;

import java.util.List;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.jhj.user.vo.JhjUserVo;

@OracleSqlMapperScan
public interface JhjLoginMapper {
	public JhjUserVo selectJhjUserPw(JhjUserVo vo);
	public JhjUserVo selectJhjUserIdEmail(JhjUserVo vo);
	public void updateJhjUserNewPw(JhjUserVo vo);
	public List<JhjUserVo> selectjhjUserId(JhjUserVo vo);
}