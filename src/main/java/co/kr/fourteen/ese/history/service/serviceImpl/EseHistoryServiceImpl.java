package co.kr.fourteen.ese.history.service.serviceImpl;

import co.kr.fourteen.ese.history.mapper.EseHistoryMapper;
import co.kr.fourteen.ese.history.service.EseHistoryService;
import co.kr.fourteen.ese.history.vo.EseHistoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EseHistoryServiceImpl implements EseHistoryService{

	@Autowired
	private EseHistoryMapper eseHistoryMapper;

	@Override
	public List<EseHistoryVo> historyList() {
		return eseHistoryMapper.historyList();
	}

}
