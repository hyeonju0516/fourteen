package co.kr.fourteen.kcm.login.mapper;

import org.apache.ibatis.annotations.Param;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.kcm.login.vo.KcmLoginVo;

@OracleSqlMapperScan
public interface KcmLoginMapper {

	public KcmLoginVo loginCheckUser(KcmLoginVo loginVo);

	public String findUserId(@Param("userNm") String userNm, @Param("userEmail") String userEmail, @Param("userPhone") String userPhone);

	public int findUserPw(KcmLoginVo loginVo);

	public int changeUserPw(KcmLoginVo loginVo);
	
	public String selectOtpCodeCheck(String userId);

	public void updateFalPw(KcmLoginVo loginVo);

	public void updateLoginUserInfo(KcmLoginVo loginVo);

	public void loginHist(KcmLoginVo loginVo);

	public void otpMerge(KcmLoginVo loginVo);

	public void updateUserOtpYn(KcmLoginVo loginVo);
	
	
}
