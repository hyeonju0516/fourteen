package co.kr.fourteen.taengEe.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.fourteen.taengEe.main.controller.KthMainController;
import co.kr.fourteen.taengEe.main.mapper.KthMapper;
import co.kr.fourteen.taengEe.main.service.KthService;
import co.kr.fourteen.taengEe.main.vo.KthVo;

@Service
public class KthServiceImpl implements KthService{

	@Autowired
	private KthMapper kthMapper;

	@Override
	public String insertUserInfo(KthVo vo) {

		kthMapper.insertUserInfo(vo);

		return "";
	};

	@Override
	public List<KthVo> selectUserInfoList(){
		return kthMapper.selectUserInfoList();
	}

}
