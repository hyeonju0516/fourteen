package co.kr.fourteen.hoseong.user.service.impl;

import co.kr.fourteen.hoseong.user.mapper.KhsUserMapper;
import co.kr.fourteen.hoseong.user.service.KhsUserService;
import co.kr.fourteen.hoseong.user.vo.KhsUserVo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhsUserServiceImpl implements KhsUserService {

    @Autowired
    private KhsUserMapper khsUserMapper;

    @Override
    public int selectUserIdCheck(String userId) {
        int idCheck = khsUserMapper.selectUserIdCheck(userId);

        return idCheck;
    }

    @Override
    public boolean insertUser(KhsUserVo vo) {
        boolean result = true;
        String hashPassword = BCrypt.hashpw(vo.getUserPw(), BCrypt.gensalt());
        vo.setUserPw(hashPassword);

        khsUserMapper.insertUser(vo);
        return result;
    }
}
