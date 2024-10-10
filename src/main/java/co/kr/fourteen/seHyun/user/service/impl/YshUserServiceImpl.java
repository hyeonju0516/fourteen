package co.kr.fourteen.seHyun.user.service.impl;

import co.kr.fourteen.seHyun.user.mapper.YshUserMapper;
import co.kr.fourteen.seHyun.user.service.YshUserService;
import co.kr.fourteen.seHyun.user.vo.YshUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YshUserServiceImpl implements YshUserService {

    @Autowired
    private YshUserMapper yshUserMapper;

    @Override
    public int idDoubleCheck(String userId) {
        return yshUserMapper.idDoubleCheck(userId);
    }

    @Override
    public String findId(String userName) {
        return yshUserMapper.findId(userName);
    }

    @Override
    public void userJoin(YshUserVo vo) {
        yshUserMapper.userJoin(vo);
    }

    @Override
    public YshUserVo userLogin(YshUserVo vo) {
        return yshUserMapper.userLogin(vo);
    }
}
