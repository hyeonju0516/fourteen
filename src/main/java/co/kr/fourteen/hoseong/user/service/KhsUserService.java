package co.kr.fourteen.hoseong.user.service;

import co.kr.fourteen.hoseong.user.vo.KhsUserVo;

public interface KhsUserService {

    public int selectUserIdCheck(String userId);

    public boolean insertUser(KhsUserVo vo);
}
