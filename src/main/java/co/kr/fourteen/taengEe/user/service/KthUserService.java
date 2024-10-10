package co.kr.fourteen.taengEe.user.service;

import co.kr.fourteen.taengEe.user.vo.KthUserVo;

public interface KthUserService {
    public boolean doubleCheckId(String userId);

    public boolean doubleCheckId2(String userId);

    public void joinCheck(KthUserVo vo);
}
