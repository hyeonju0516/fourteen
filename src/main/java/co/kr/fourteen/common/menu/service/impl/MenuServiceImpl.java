package co.kr.fourteen.common.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.common.menu.mapper.MenuMapper;
import co.kr.fourteen.common.menu.service.MenuService;
import co.kr.fourteen.common.menu.vo.MenuVo;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<MenuVo> mainTopMenuList() {
		return menuMapper.mainTopMenuList();
	}
}
