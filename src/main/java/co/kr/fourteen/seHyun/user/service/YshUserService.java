package co.kr.fourteen.seHyun.user.service;

import co.kr.fourteen.seHyun.user.vo.YshUserVo;

public interface YshUserService {

    public int idDoubleCheck(String userId);

    public String findId(String userName);

    public void userJoin(YshUserVo vo);

    public YshUserVo userLogin(YshUserVo vo);
}
