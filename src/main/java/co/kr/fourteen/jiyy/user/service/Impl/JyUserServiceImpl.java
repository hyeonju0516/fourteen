package co.kr.fourteen.jiyy.user.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.jiyy.user.mapper.JyUserMapper;
import co.kr.fourteen.jiyy.user.service.JyUserService;
import co.kr.fourteen.jiyy.user.vo.JyUserVo;

@Service
public class JyUserServiceImpl implements JyUserService{

	@Autowired
	private JyUserMapper jyUserMapper;

	@Override
	public boolean userIdCheck(String userId) {
		return jyUserMapper.userIdCheck(userId);
	}

	@Override
	public List<JyUserVo> userJoinData(JyUserVo userData){
		return jyUserMapper.userJoinData(userData);
	}

	@Override
	public JyUserVo userLoginCheck(JyUserVo userLoginDt){
		return jyUserMapper.userLoginCheck(userLoginDt);
	}
}
