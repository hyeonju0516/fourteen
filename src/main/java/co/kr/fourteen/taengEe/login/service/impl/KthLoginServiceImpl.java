package co.kr.fourteen.taengEe.login.service.impl;

import co.kr.fourteen.taengEe.login.mapper.KthLoginMapper;
import co.kr.fourteen.taengEe.login.service.KthLoginService;
import co.kr.fourteen.taengEe.login.vo.KthLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KthLoginServiceImpl implements KthLoginService {

    @Autowired
    private KthLoginMapper kthLoginMapper;

    @Override
    public KthLoginVo loginCheck(KthLoginVo vo) {
        return kthLoginMapper.loginCheck(vo);
    }
}
