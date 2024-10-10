package co.kr.fourteen.hoseong.login.service.impl;

import co.kr.fourteen.hoseong.login.mapper.KhsLoginMapper;
import co.kr.fourteen.hoseong.login.service.KhsLoginService;
import co.kr.fourteen.hoseong.user.vo.KhsUserVo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhsLoginServiceImpl implements KhsLoginService {

    @Autowired
    private KhsLoginMapper khsLoginMapper;

    @Override
    public KhsUserVo selectLoginCheck(KhsUserVo vo) {
        KhsUserVo resultVo = khsLoginMapper.selectLoginCheck(vo);

        resultVo.setResultUrl("/khs/hsMain");

        if (!BCrypt.checkpw(vo.getUserPw(), resultVo.getUserPw())) {
            resultVo.setResultUrl("/khs/login");
        }

        return resultVo;
    }
}
