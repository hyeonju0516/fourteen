package co.kr.fourteen.taengEe.user.service.impl;

import co.kr.fourteen.taengEe.user.mapper.KthUserMapper;
import co.kr.fourteen.taengEe.user.service.KthUserService;
import co.kr.fourteen.taengEe.user.vo.KthUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KthUserServiceImpl implements KthUserService {

    @Autowired
    private KthUserMapper kthUserMapper;

    @Override
    public boolean doubleCheckId(String userId) {
        boolean result = false;
        int cnt = kthUserMapper.doubleCheckId(userId);
        if(cnt > 0) result = true;
        return result;
    }

    @Override
    public boolean doubleCheckId2(String userId) {
        boolean result = true;
        int checked = kthUserMapper.doubleCheckId2(userId);
        if(checked > 0) result = false;
        return result;
    }

    @Override
    public void joinCheck(KthUserVo vo) {
        String password = vo.getUserPw();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        vo.setUserPw(hashedPassword);

        kthUserMapper.joinCheck(vo);
    }
}
