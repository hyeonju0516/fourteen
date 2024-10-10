package co.kr.fourteen.hoseong.menu.service.impl;

import co.kr.fourteen.hoseong.menu.mapper.KhsMenuMapper;
import co.kr.fourteen.hoseong.menu.service.KhsMenuService;
import co.kr.fourteen.hoseong.menu.vo.KhsMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhsKhsMenuServiceImpl implements KhsMenuService {

	@Autowired
	private KhsMenuMapper khsMenuMapper;

	/**
	 * @Method hsMainTopMenuList
	 * @Date 2024. 05. 06.
	 * @Writter gak098(곽호성)
	 * @EditHistory
	 * @Discript HoSeong mainTopMenuList Page.
	 * @Return String
	 */
	@Override
	public List<KhsMenuVo> hsMainTopMenuList() {
		return khsMenuMapper.hsMainTopMenuList();
	}
}
