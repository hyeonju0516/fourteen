package co.kr.fourteen.jhj.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.jhj.user.mapper.JhjUserMapper;
import co.kr.fourteen.jhj.user.service.JhjUserService;
import co.kr.fourteen.jhj.user.vo.JhjUserVo;

@Service
public class JhjUserSerciveImpl implements JhjUserService {

	private JhjUserMapper jhjUserMapper = null;

	@Autowired
	public JhjUserSerciveImpl(JhjUserMapper jhjUserMapper) {
		this.jhjUserMapper = jhjUserMapper;
	}

	@Override
	public boolean doubleCheckUser(String userId) {
		return false;
	}

	@Override
	public void insertJhjUserJoin(JhjUserVo vo) {
		jhjUserMapper.insertJhjUserJoin(vo);
	}
}
