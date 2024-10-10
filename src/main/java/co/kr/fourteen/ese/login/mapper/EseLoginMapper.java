package co.kr.fourteen.ese.login.mapper;


import co.kr.fourteen.common.annotation.OracleSqlMapperScan;
import co.kr.fourteen.ese.login.vo.EseLoginVo;
import org.apache.ibatis.annotations.Param;
@OracleSqlMapperScan
public interface EseLoginMapper {

	// 로그인
	public EseLoginVo login(EseLoginVo userVo);

	// 아이디 찾기
	public String findId(String userPhone);

	// 비밀번호 찾기
	public String findEmailByUserId(@Param("userId") String userId);

	// 비밀번호 초기화
	public void updatePassword(@Param("userId") String userId, @Param("password") String password);

	public String selectOtpCodeCheck(String userId);

	public EseLoginVo selectUserLoginCheck(EseLoginVo loginVo);

	public void otpMerge(EseLoginVo loginVo);

	public void updateUserOtpYn(EseLoginVo loginVo);
}



