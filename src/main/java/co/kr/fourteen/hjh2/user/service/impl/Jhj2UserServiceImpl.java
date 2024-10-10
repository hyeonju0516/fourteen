package co.kr.fourteen.hjh2.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.hjh2.user.mapper.Jhj2UserMapper;
import co.kr.fourteen.hjh2.user.service.Jhj2UserService;
import co.kr.fourteen.hjh2.user.vo.Jhj2UserInfoVo;

@Service
public class Jhj2UserServiceImpl implements Jhj2UserService {
	@Autowired
	private Jhj2UserMapper mapper;

	@Override
	public boolean doubleCheckId(String userId) {
		boolean result = false;
		int cnt = mapper.doubleCheckId(userId);
		if(cnt > 0) result = true;
		return result;
	}

	@Override
	public boolean userJoin(Jhj2UserInfoVo vo) {
		boolean result = false;
		int cnt = mapper.userJoin(vo);
		if(cnt > 0) result = true;
		return result;
	}

	@Override
	public Jhj2UserInfoVo userLogin(String id, String pw) {
		return mapper.userLogin(id, pw);
	}
}
