package co.kr.fourteen.ese.user.service.impl;

import co.kr.fourteen.common.util.CustomException;
import co.kr.fourteen.common.util.Rsa;
import co.kr.fourteen.ese.user.mapper.EseUserMapper;
import co.kr.fourteen.ese.user.service.EseUserService;
import co.kr.fourteen.ese.user.vo.EseUserVo;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class EseUserServiceImpl implements EseUserService {

	@Autowired
	private EseUserMapper eseUserMapper;

	@Override
	public boolean doubleCheckId(String userId) {
		boolean result = false;
		try {
			int cnt = eseUserMapper.doubleCheckId(userId);
			if(cnt > 0) result = true;
		} catch (Exception e) {
			new CustomException("DB EXCEPT", e);
		}
		return result;
	}

	@Override
	public List<EseUserVo> userList() {
		return eseUserMapper.userList();
	}

	@Override
	public void insertInfo(EseUserVo info, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		//복호화

		Rsa rsa = new Rsa();
		PrivateKey privateKey = (PrivateKey) session.getAttribute(Rsa.RSA_WEB_KEY);
		info.setUserPw(BCrypt.hashpw(rsa.decryptRsa(privateKey, info.getUserPw()), BCrypt.gensalt()));		// 암호화 저장
		eseUserMapper.insertInfo(info);

	}



}
