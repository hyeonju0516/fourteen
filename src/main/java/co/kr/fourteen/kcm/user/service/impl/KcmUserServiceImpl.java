package co.kr.fourteen.kcm.user.service.impl;

import java.security.PrivateKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.common.util.Rsa;
import co.kr.fourteen.kcm.user.mapper.KcmUserMapper;
import co.kr.fourteen.kcm.user.service.KcmUserService;
import co.kr.fourteen.kcm.user.vo.KcmUserInfoVo;



@Service
public class KcmUserServiceImpl implements KcmUserService {

	@Autowired
	private KcmUserMapper kcmUserMapper;

	@Override
	public boolean doubleCheckId(String userId) {
		boolean result = false;
		int cnt = kcmUserMapper.doubleCheckId(userId);

		if(cnt > 0) result = true;
		return result;
	}

	@Override
	public boolean userJoin(KcmUserInfoVo vo, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		boolean result = false;

		// 복호화
		Rsa rsa = new Rsa();
		PrivateKey privateKey = (PrivateKey) session.getAttribute(Rsa.RSA_WEB_KEY);

		vo.setUserPw(BCrypt.hashpw(rsa.decryptRsa(privateKey, vo.getUserPw()), BCrypt.gensalt()));

		int cnt = kcmUserMapper.userJoin(vo);

		if (cnt > 0) result = true;
		return result;
	}

}
