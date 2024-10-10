package co.kr.fourteen.cyj.user.service.impl;

import java.security.PrivateKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.common.util.CustomException;
import co.kr.fourteen.common.util.Rsa;
import co.kr.fourteen.cyj.user.mapper.CyjUserMapper;
import co.kr.fourteen.cyj.user.service.CyjUserService;
import co.kr.fourteen.cyj.user.vo.CyjUserVo;

@Service
public class CyjUserServiceImpl implements CyjUserService {

	@Autowired
	private CyjUserMapper cyjUserMapper;

	@Override
	public boolean doubleCheckId(String userId) {
		boolean result = false;
		try {
			int cnt = cyjUserMapper.doubleCheckId(userId);
			if(cnt > 0) result = true;
		} catch (Exception e) {
			new CustomException("DB EXCEPT", e);
		}
		return result;
	}

	@Override
	public void userJoin(CyjUserVo userVo, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		//복호화
		Rsa rsa = new Rsa();
		PrivateKey privateKey = (PrivateKey) session.getAttribute(Rsa.RSA_WEB_KEY);
		userVo.setUserPw(BCrypt.hashpw(rsa.decryptRsa(privateKey, userVo.getUserPw()), BCrypt.gensalt()));		// 암호화 저장
		cyjUserMapper.userJoin(userVo);
	}
}
