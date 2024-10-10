package co.kr.fourteen.cyj.login.mapper;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.cyj.login.vo.CyjLoginVo;

@OracleSqlMapperScan
public interface CyjLoginMapper {

	public CyjLoginVo selectUserLoginCheck(CyjLoginVo loginVo);

	public String selectOtpCodeCheck(String userId);

	public void updateFalPw(CyjLoginVo loginVo);

	public void updateLoginUserInfo(CyjLoginVo loginVo);

	public void loginHist(CyjLoginVo loginVo);

	public void otpMerge(CyjLoginVo loginVo);

	public void updateUserOtpYn(CyjLoginVo loginVo);
}
