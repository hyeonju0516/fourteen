package co.kr.fourteen.seHyun.practice.menu.service.impl;

import co.kr.fourteen.seHyun.practice.menu.mapper.ShPracticeMenuMapper;
import co.kr.fourteen.seHyun.practice.menu.service.ShPracticeMenuService;
import co.kr.fourteen.seHyun.practice.menu.vo.ShPracticeMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShPracticeMenuServiceImpl implements ShPracticeMenuService {

    @Autowired
    public ShPracticeMenuMapper shPracticeMenuMapper;

    public List<ShPracticeMenuVo> listAll() {
        return shPracticeMenuMapper.listAll();
    }
}
