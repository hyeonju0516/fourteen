package co.kr.fourteen.seHyun.practice.user.service.impl;

import co.kr.fourteen.seHyun.practice.user.mapper.YshPracticeUserMapper;
import co.kr.fourteen.seHyun.practice.user.service.YshPracticeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YshPracticeUserServiceImpl implements YshPracticeUserService {

    @Autowired
    private YshPracticeUserMapper yshPracticeUserMapper;

    @Override
    public boolean idDoubleCheckBool(String userId) {
        boolean result = false;

        int count = yshPracticeUserMapper.idDoubleCheckBool(userId);

        if (count > 0) result = true;

        return result;
    }

    @Override
    public int idDoubleCheckInt(String userId) {
        int count = 0;

        String id = yshPracticeUserMapper.idDoubleCheckInt(userId);

        if (id == null) return count;

        if (id.equals(userId)) count = 1;

        return count;
    }
}
