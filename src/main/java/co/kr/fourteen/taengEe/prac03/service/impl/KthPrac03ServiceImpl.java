package co.kr.fourteen.taengEe.prac03.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.taengEe.prac03.mapper.KthPrac03Mapper;
import co.kr.fourteen.taengEe.prac03.service.KthPrac03Service;
import co.kr.fourteen.taengEe.prac03.vo.KthPrac03Vo;

@Service
public class KthPrac03ServiceImpl implements KthPrac03Service{

	@Autowired
	private KthPrac03Mapper kthPrac03Mapper;

	@Override
	public void addInfo(KthPrac03Vo vo) {
		kthPrac03Mapper.addInfo(vo);
	}

	@Override
	public List<KthPrac03Vo> list() {

		return kthPrac03Mapper.list();
	}

}
