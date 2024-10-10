package co.kr.fourteen.seHyun.practice.search.service;

import co.kr.fourteen.seHyun.practice.search.vo.YshSearchVo;

import java.util.List;

public interface YshSearchService {
    public int idSearching(String userId);

    public List<YshSearchVo> joinChecking(String userName);
}
