package co.kr.fourteen.seHyun.practice.search.service.impl;

import co.kr.fourteen.seHyun.practice.search.mapper.YshSearchMapper;
import co.kr.fourteen.seHyun.practice.search.service.YshSearchService;
import co.kr.fourteen.seHyun.practice.search.vo.YshSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YshSearchServiceImpl implements YshSearchService {

    @Autowired
    private YshSearchMapper yshSearchMapper;

    @Override
    public int idSearching(String userId) {
        int result = 0;

        boolean search = yshSearchMapper.idSearching(userId);

        if (search) result = 1;

        return result;
    }

    @Override
    public List<YshSearchVo> joinChecking(String userName) {
        return yshSearchMapper.joinChecking(userName);
    }
}
