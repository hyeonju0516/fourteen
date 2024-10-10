package co.kr.fourteen.ese.main.service.impl;

import co.kr.fourteen.ese.main.mapper.EseMainMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EseMainServiceImpl {

	private final EseMainMapper esemainMapper;
}
