package co.kr.fourteen.hjh2.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.hjh2.main.mapper.Jhj2MenuMapper;
import co.kr.fourteen.hjh2.main.service.Jhj2MenuService;
import co.kr.fourteen.hjh2.main.vo.Jhj2MenuVo;

@Service
public class Jhj2MenuServiceImpl implements Jhj2MenuService {

	@Autowired
	private Jhj2MenuMapper mapper;

	public List<Jhj2MenuVo> mainTopMenuList(){
		return mapper.mainTopMenuList();
	}
}
