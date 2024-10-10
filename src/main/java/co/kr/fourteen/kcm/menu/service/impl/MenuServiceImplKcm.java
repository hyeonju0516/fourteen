package co.kr.fourteen.kcm.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.kcm.menu.mapper.MenuMapperKcm;
import co.kr.fourteen.kcm.menu.service.MenuServiceKcm;
import co.kr.fourteen.kcm.menu.vo.MenuVoKcm;



@Service
public class MenuServiceImplKcm implements MenuServiceKcm {

	@Autowired
	private MenuMapperKcm menuMapper;

	@Override
	public List<MenuVoKcm> mainTopMenuList() {
		return menuMapper.mainTopMenuList();
	}
}
