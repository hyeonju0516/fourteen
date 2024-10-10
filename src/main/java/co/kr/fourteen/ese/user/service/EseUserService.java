package co.kr.fourteen.ese.user.service;

import co.kr.fourteen.ese.user.vo.EseUserVo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface EseUserService {

	public boolean doubleCheckId(String userId);

	public void insertInfo(EseUserVo info, HttpServletRequest req) throws Exception;

	public List<EseUserVo> userList();

}
