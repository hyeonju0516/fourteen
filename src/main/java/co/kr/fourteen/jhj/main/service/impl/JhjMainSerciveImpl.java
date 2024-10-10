package co.kr.fourteen.jhj.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.jhj.main.service.JhjMainSercive;
import co.kr.fourteen.jhj.user.mapper.JhjUserMapper;

@Service
public class JhjMainSerciveImpl implements JhjMainSercive {

	private JhjUserMapper JhjUserMapper = null;

	@Autowired
	public JhjMainSerciveImpl(JhjUserMapper JhjUserMapper) {
		this.JhjUserMapper = JhjUserMapper;
	}
}
