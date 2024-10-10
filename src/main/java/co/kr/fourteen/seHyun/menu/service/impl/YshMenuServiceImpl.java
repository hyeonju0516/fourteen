package co.kr.fourteen.seHyun.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.seHyun.menu.mapper.YshMenuMapper;
import co.kr.fourteen.seHyun.menu.service.YshMenuService;
import co.kr.fourteen.seHyun.menu.vo.YshMenuVo;

@Service
public class YshMenuServiceImpl implements YshMenuService{

	@Autowired
	public YshMenuMapper yshMenuMapper;

	@Override
	public List<YshMenuVo> mainTopMenuList() {
		return yshMenuMapper.mainTopMenuList();
	}
}
