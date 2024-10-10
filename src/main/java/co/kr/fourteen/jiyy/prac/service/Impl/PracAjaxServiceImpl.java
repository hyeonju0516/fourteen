package co.kr.fourteen.jiyy.prac.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.jiyy.prac.mapper.PracAjaxMapper;
import co.kr.fourteen.jiyy.prac.service.PracAjaxService;
import co.kr.fourteen.jiyy.prac.vo.PracAjaxVo;

@Service
public class PracAjaxServiceImpl implements PracAjaxService {

	@Autowired
	private PracAjaxMapper pracAjaxMapper;

	@Override
	public List<PracAjaxVo> selectList(String regId){
		return pracAjaxMapper.selectList(regId);
	}
}
