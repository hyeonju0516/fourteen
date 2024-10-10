package co.kr.fourteen.jiyy.prac.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.jiyy.prac.mapper.JyPracUserMapper;
import co.kr.fourteen.jiyy.prac.service.JyPracUserService;

@Service
public class JyPracUserServiceImpl implements JyPracUserService{

	@Autowired
	private JyPracUserMapper jyPracUserMapper;

	@Override
	public boolean userIdCheck(String userId) {
		boolean result = false;
		int idCheck = jyPracUserMapper.userIdCheck(userId);
		if(idCheck > 0) result = true;
		return result;
	}
}
