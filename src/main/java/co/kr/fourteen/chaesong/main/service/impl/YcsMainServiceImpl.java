package co.kr.fourteen.chaesong.main.service.impl;

import org.springframework.stereotype.Service;

import co.kr.fourteen.chaesong.main.mapper.YcsMainMapper;
import co.kr.fourteen.chaesong.main.service.YcsMainService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class YcsMainServiceImpl implements YcsMainService {

	private final YcsMainMapper ycsMainMapper;

	@Override
	public String selectUserInfo(String name) {
		return "".equals(name) ? "" : ycsMainMapper.selectUserInfo(name);
	}
}
