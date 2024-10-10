package co.kr.fourteen.hoseong.login.service;


import co.kr.fourteen.hoseong.user.vo.KhsUserVo;

public interface KhsLoginService {

    public KhsUserVo selectLoginCheck(KhsUserVo vo);
}
