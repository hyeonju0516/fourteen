package co.kr.fourteen.jiyy.menu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.jiyy.menu.mapper.JyMenuMapper;
import co.kr.fourteen.jiyy.menu.service.JyMenuService;
import co.kr.fourteen.jiyy.menu.vo.JyMenuVo;

@Service
public class JyMenuServiceImpl implements JyMenuService {

	@Autowired
	private JyMenuMapper jyMenuMapper;

	@Override
	public List<JyMenuVo> mainTopMenu(){
		return jyMenuMapper.mainTopMenu();
	}
}
