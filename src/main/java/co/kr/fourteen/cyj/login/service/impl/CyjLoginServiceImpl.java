package co.kr.fourteen.cyj.login.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.common.util.FrontBackErrorCode;
import co.kr.fourteen.common.util.GoogleOtp;
import co.kr.fourteen.cyj.login.mapper.CyjLoginMapper;
import co.kr.fourteen.cyj.login.service.CyjLoginService;
import co.kr.fourteen.cyj.login.vo.CyjLoginVo;

@Service
public class CyjLoginServiceImpl implements CyjLoginService {

	@Autowired
	private CyjLoginMapper cyjLoginMapper;

	@Override
	public CyjLoginVo selectUserLoginCheck(CyjLoginVo loginVo) {
		return cyjLoginMapper.selectUserLoginCheck(loginVo);
	}

	@Override
	public Map<String, Object> otpCodeCheck(String otpCode, String userId) {
		GoogleOtp otp = new GoogleOtp();
		Map<String, Object> map = new HashMap<String, Object>();
		String otpkey = cyjLoginMapper.selectOtpCodeCheck(userId);
		boolean result = false;
		if(otpkey == null) {
			map.put(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.MD0006);
			map.put(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.MD0006_MSG);
			return map;
		}

		result = otp.checkCode(otpkey, otpCode);

		if(!result) {
			map.put(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.MD0007);
			map.put(FrontBackErrorCode.RESULT_MSG, FrontBackErrorCode.MD0007_MSG);
			return map;
		}

		map.put(FrontBackErrorCode.RESULT_CD, FrontBackErrorCode.CM0000);
		return map;
	}

	@Override
	public void updateFalPw(CyjLoginVo loginVo) {
		cyjLoginMapper.updateFalPw(loginVo);
	}

	@Override
	public void updateLoginUserInfo(CyjLoginVo loginVo) throws Exception {
		cyjLoginMapper.loginHist(loginVo);
		cyjLoginMapper.updateLoginUserInfo(loginVo);
	}

	@Override
	public void otpMerge(CyjLoginVo loginVo) throws Exception {
		cyjLoginMapper.updateUserOtpYn(loginVo);
		cyjLoginMapper.otpMerge(loginVo);
	}

}
