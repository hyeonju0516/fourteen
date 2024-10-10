package co.kr.fourteen.jiyy.prac.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.jiyy.prac.mapper.JyAjaxMapper;
import co.kr.fourteen.jiyy.prac.service.JyAjaxService;
import co.kr.fourteen.jiyy.prac.vo.PracAjaxVo;

@Service
public class JyAjaxServiceImpl implements JyAjaxService{

	@Autowired
	private JyAjaxMapper jyAjaxMapper;

	@Override
	public List<PracAjaxVo> dataResult(String jyData) {
		return jyAjaxMapper.dataResult(jyData);
	}

	@Override
	public boolean userIdCheck(String userId) {
		boolean result = false;
		int userIdCount = jyAjaxMapper.userIdCheck(userId);
		if(userIdCount > 0) result = true;
		return result;
	}
}
