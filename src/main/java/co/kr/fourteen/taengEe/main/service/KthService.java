package co.kr.fourteen.taengEe.main.service;

import java.util.List;

import co.kr.fourteen.taengEe.main.vo.KthVo;

public interface KthService {

	public String insertUserInfo(KthVo vo);

	List<KthVo> selectUserInfoList();

}
