package co.kr.fourteen.jiyy.prac.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.jiyy.prac.mapper.JyPracMenuMapper;
import co.kr.fourteen.jiyy.prac.service.JyPracMenuService;
import co.kr.fourteen.jiyy.prac.vo.topMenuPracVo;

@Service
public class JyPracMenuServiceImpl implements JyPracMenuService{

	@Autowired
	private JyPracMenuMapper jyPracMenuMapper;

	@Override
	public List<topMenuPracVo> headerMenuView(){
		return jyPracMenuMapper.headerMenuView();
	}



}
